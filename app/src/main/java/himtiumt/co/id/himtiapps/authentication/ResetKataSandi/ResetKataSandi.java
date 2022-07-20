package himtiumt.co.id.himtiapps.authentication.ResetKataSandi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model.RequestResetPassword;
import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model.ResponseResetPassword;
import himtiumt.co.id.himtiapps.authentication.login.LoginActivity;
import himtiumt.co.id.himtiapps.authentication.register.Model.RequestRegister;
import himtiumt.co.id.himtiapps.databinding.ActivityResetKataSandiBinding;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetKataSandi extends AppCompatActivity {

    // Hook
    ImageView returnResetPassword;
    MaterialButton materialSimpan;
    ActivityResetKataSandiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResetKataSandiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hooks
        returnResetPassword = findViewById(R.id.ClickReturn);

        // View OnClick
        materialSimpan = findViewById(R.id.MaterialSimpan);


        returnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnPassword = new Intent(ResetKataSandi.this, LoginActivity.class);
                startActivity(returnPassword);
            }
        });

        binding.MaterialSimpan.setOnClickListener(view -> {
          String Email = binding.textInputEmail.getText().toString();
          String Password = binding.textInputPassword.getText().toString();
          String ConfirmPassword = binding.textInputPassword1.getText().toString();

          if (TextUtils.isEmpty(Email)) {
              binding.textInputEmail.setError("Email Tidak Boleh Kosong");
          } else if (TextUtils.isEmpty(Password)) {
              binding.textInputPassword.setError("Password tidak boleh kosong");
          } else if (!Password.equals(ConfirmPassword)) {
              binding.textInputPassword1.setError("Password tidak sesuai");
          } else {
              resetPassword(Email,Password);
          }

        });

    }

    private void resetPassword(String email, String password) {
        RequestResetPassword requestResetPassword = new RequestResetPassword();
        requestResetPassword.setEmail(email);
        requestResetPassword.setPassword(password);
        ApiConfig.service.resetpassword(requestResetPassword).enqueue(new Callback<ResponseResetPassword>() {
            @Override
            public void onResponse(Call<ResponseResetPassword> call, Response<ResponseResetPassword> response) {
                if (response.isSuccessful()){
                    ResponseResetPassword responseResetPassword = response.body();
                    boolean sukses = responseResetPassword.isStatus();
                    if (sukses) {
                        String Massage = responseResetPassword.getMessage();
                        Toast.makeText(ResetKataSandi.this, Massage, Toast.LENGTH_SHORT).show();

                        Intent simpanPerubahan = new Intent(ResetKataSandi.this, VerifiedAkun.class);
                        startActivity(simpanPerubahan);

                    } else {
                        String Massage = responseResetPassword.getMessage();
                        Toast.makeText(ResetKataSandi.this, Massage, Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(ResetKataSandi.this, "Response gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseResetPassword> call, Throwable t) {
                Toast.makeText(ResetKataSandi.this, "Periksa jaringan anda", Toast.LENGTH_SHORT).show();

            }
        });
    }
}