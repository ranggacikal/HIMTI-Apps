package himtiumt.co.id.himtiapps.authentication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SharedMemory;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.UI.LoadingBar;
import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.ResetKataSandi;
import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.authentication.register.RegisterActivity;
import himtiumt.co.id.himtiapps.home.MainActivity;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText eTextEmail, eTextPassword;
    TextView tvLupaPassword, tvDaftarAkun, tvProgressBar;
    Button btnMasuk;
    ProgressBar progressBar;
    private SharedPreferences sharedPreferences;
    final LoadingBar loadingBar = new LoadingBar(LoginActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("myapp-data", MODE_PRIVATE);

        eTextEmail = findViewById(R.id.ti_email);
        eTextPassword = findViewById(R.id.ti_password);
        tvLupaPassword = findViewById(R.id.tv_lupa_password);
        tvDaftarAkun = findViewById(R.id.tv_daftar_akun);
        btnMasuk = findViewById(R.id.btn_masuk);
        progressBar = findViewById(R.id.pb_LoadingPage);
        tvProgressBar = findViewById(R.id.tv_LoadingPage);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int position = 1;
        editor.putInt("position",position);
        editor.apply();

        tvLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resetPassword = new Intent(LoginActivity.this, ResetKataSandi.class);
                startActivity(resetPassword);
            }
        });

        tvDaftarAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftarAkun = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(daftarAkun);
            }
        });

        btnMasuk.setOnClickListener(v -> {
            login(eTextEmail.getText().toString(), eTextPassword.getText().toString());

        });
    }

    private void login(String email, String password){

        if (TextUtils.isEmpty(email)){
            eTextEmail.setError("NIM Tidak Boleh Kosong");
        } else if (TextUtils.isEmpty(password)) {
            eTextPassword.setError("NIM Tidak Boleh Kosong");
        } else {
            loadingBar.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    loadingBar.dismissDialog();
                }
            }, 1000);
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("password", password);
        editor.apply();

        // Model yang dibuat dari API, Model Request
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setEmail(email);
        requestLogin.setPassword(password);

        ApiConfig.service.login(requestLogin).enqueue(new Callback<ResponseLogin>() {

            // Berhasil komunikasi ke API
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if (response.isSuccessful()){
                    // response code 200

                    ResponseLogin responseLogin = response.body();
                    boolean success = responseLogin.isStatus();
                    if (success){
                        int id = responseLogin.getDataLogin().getId();
                        String email = responseLogin.getDataLogin().getEmail();
                        String notelephone = responseLogin.getDataLogin().getNoHp();
                        String name = responseLogin.getDataLogin().getName();
                        Toast.makeText(LoginActivity.this, "Selamat datang " + name, Toast.LENGTH_SHORT).show();

                        // next logic

                        // intent ke Home
                        Intent LandingPage = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(LandingPage);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("id", id );
                        editor.putString("usernamw", name);
                        editor.putString("email", email);
                        editor.putString("notelephone", notelephone);
                        editor.apply();
                    } else {
                        String massage = responseLogin.getMessage();
                        Toast.makeText(LoginActivity.this, "ya gagal dah", Toast.LENGTH_SHORT).show();
                    }

                } else{
                    Toast.makeText(LoginActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                }
            }

            // Tidak ada Koneksi Internet
            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}