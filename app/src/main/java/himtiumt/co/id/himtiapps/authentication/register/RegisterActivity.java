package himtiumt.co.id.himtiapps.authentication.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.authentication.login.LoginActivity;
import himtiumt.co.id.himtiapps.authentication.register.Model.RequestRegister;
import himtiumt.co.id.himtiapps.authentication.register.Model.ResponseRegister;
import himtiumt.co.id.himtiapps.databinding.ActivityRegisterBinding;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    // Hook
    ImageView returnRegister;
    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Storage Instructions
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Eliminate ActionBar
        getSupportActionBar().hide();

        // Hooks
        returnRegister = findViewById(R.id.ClickReturns);

        // Send Documents - View OnCLick
        returnRegister.setOnClickListener(view -> {
            Intent ReturnRegister = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(ReturnRegister);
        });

        binding.mbDaftarAkun.setOnClickListener(view -> {
            register(binding.tiPenggunaAkun.getText().toString(), binding.tiEmailRegister.getText().toString()
                    , binding.tiNoTelephone.getText().toString(), binding.tiPasswords.getText().toString(), binding.tiKonfirmasiPasswords.getText().toString());
        });
    }

    private void register(String NamaPengguna, String Email, String NoTelephone, String Password, String ConfirmPassword) {

        if (TextUtils.isEmpty(NamaPengguna)){
            binding.tiPenggunaAkun.setError("NIM Tidak Boleh Kosong");
        } else if (TextUtils.isEmpty(Email)) {
            binding.tiEmailRegister.setError("Password Tidak Boleh Kosong");
        } else if (TextUtils.isEmpty(NoTelephone)) {
            binding.tiNoTelephone.setError("Password Tidak Boleh Kosong");
        } else if (TextUtils.isEmpty(Password)) {
            binding.tiPasswords.setError("Password Tidak Boleh Kosong");
        } else if (TextUtils.isEmpty(ConfirmPassword)) {
            binding.tiKonfirmasiPasswords.setError("Password Tidak Boleh Kosong");
        }

        RequestRegister requestRegister = new RequestRegister();
        requestRegister.setName(NamaPengguna);
        requestRegister.setEmail(Email);
        requestRegister.setNoHp(NoTelephone);
        requestRegister.setPassword(Password);
        requestRegister.setVerifikasiPassword(ConfirmPassword);
        ApiConfig.service.register(requestRegister).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()) {
                    ResponseRegister responseRegister = response.body();
                    boolean succes = responseRegister.isStatus();
                    if (succes) {
                        Toast.makeText(RegisterActivity.this, "Welcome HIMTI Apps", Toast.LENGTH_SHORT).show();
                        Intent Login = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(Login);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Email sudah terdaftar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Sistem Maintance", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}