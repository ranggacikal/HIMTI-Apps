package himtiumt.co.id.himtiapps.authentication.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.UI.LoadingBar;
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
    final LoadingBar loadingBar = new LoadingBar(RegisterActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Storage Instructions
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hooks
        returnRegister = findViewById(R.id.ClickReturns);

        // Send Documents - View OnCLick
        returnRegister.setOnClickListener(view -> {
            Intent ReturnRegister = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(ReturnRegister);
            finish();
        });

        binding.mbDaftarAkun.setOnClickListener(view -> {
            String userName = binding.tiPenggunaAkun.getText().toString();
            String emailRegister = binding.tiEmailRegister.getText().toString();
            String noHp = binding.tiNoTelephone.getText().toString();
            String password = binding.tiPasswords.getText().toString();
            String confirmPassword = binding.tiKonfirmasiPasswords.getText().toString();

            if (TextUtils.isEmpty(userName)) {
                binding.tiPenggunaAkun.setError("Nama Pengguna Tidak Boleh Kosong");
            } else if (TextUtils.isEmpty(emailRegister)) {
                binding.tiEmailRegister.setError("Email Tidak Boleh Kosong");
            } else if (TextUtils.isEmpty(noHp)) {
                binding.tiNoTelephone.setError("No. Telp Tidak Boleh Kosong");
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
            } else if (!binding.cbKebijakanPrivasi.isChecked()) {
                Toast.makeText(this, "Harap Mempersetujui Syarat dan Ketentua", Toast.LENGTH_SHORT).show();
            } else {
                register(binding.tiPenggunaAkun.getText().toString(), binding.tiEmailRegister.getText().toString()
                        , binding.tiNoTelephone.getText().toString(), binding.tiPasswords.getText().toString(), binding.tiKonfirmasiPasswords.getText().toString());
                loadingBar.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        loadingBar.dismissDialog();
                    }
                }, 1000);

            }
        });

        binding.syaratKetentua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogSyaratKetentuan();
            }
        });

        binding.kebijakanPrivasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogKebijakanPrivasi();
            }
        });

    }

    private void openDialogKebijakanPrivasi() {
        kebijakanPrivasiPopupDialog kebijakanPrivasiPopupDialog = new kebijakanPrivasiPopupDialog();
        kebijakanPrivasiPopupDialog.show(getSupportFragmentManager(), "kebijakan privasi popup");
    }

    private void openDialogSyaratKetentuan() {
        syaratKetentuanPopup syaratKetentuanPopup = new syaratKetentuanPopup();
        syaratKetentuanPopup.show(getSupportFragmentManager(), "syarat ketentuan popup");
    }

    private void register(String NamaPengguna, String Email, String NoTelephone, String Password, String ConfirmPassword) {
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
                        Toast.makeText(RegisterActivity.this, "Akun Berhasil Terdaftar", Toast.LENGTH_SHORT).show();
                        Intent Login = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(Login);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Akun Gagal Terdaftar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}