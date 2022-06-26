package himtiumt.co.id.himtiapps.authentication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText tiEmail;
    EditText edtPassword;
    TextView tvLupaPassword, tvDaftarAkun;
    Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tiEmail = findViewById(R.id.ti_email);
        edtPassword = findViewById(R.id.edt_password);
        tvLupaPassword = findViewById(R.id.tv_lupa_password);
        tvDaftarAkun = findViewById(R.id.tv_daftar_akun);
        btnMasuk = findViewById(R.id.btn_masuk);

        btnMasuk.setOnClickListener(v -> {
            login(tiEmail.getText().toString(), edtPassword.getText().toString());
        });

    }

    private void login(String email, String password){

        // model yang dibuat dari API, model request
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setEmail(email);
        requestLogin.setPassword(password);

        ApiConfig.service.login(requestLogin).enqueue(new Callback<ResponseLogin>() {

            // berhasil komunikasi ke API
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if (response.isSuccessful()){
                    // response code 200

                    ResponseLogin responseLogin = response.body();
                    boolean success = responseLogin.isStatus();
                    if (success){
                        String name = responseLogin.getDataLogin().getName();
                        Toast.makeText(LoginActivity.this, "Selamat datang " + name, Toast.LENGTH_SHORT).show();

                        // next logic
                        // intent ke Home
                    }
                    else{
                        String message = responseLogin.getMessage();
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                }
            }

            // ga ada internet / koneksi
            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "no internet connection", Toast.LENGTH_SHORT).show();
            }
        });

    }
}