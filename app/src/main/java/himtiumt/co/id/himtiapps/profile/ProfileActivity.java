package himtiumt.co.id.himtiapps.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.UI.LoadingBar;
import himtiumt.co.id.himtiapps.authentication.login.LoginActivity;
import himtiumt.co.id.himtiapps.databinding.ActivityProfileBinding;
import himtiumt.co.id.himtiapps.home.MainActivity;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.profile.Model.RequestProfile;
import himtiumt.co.id.himtiapps.profile.Model.ResponseProfile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private SharedPreferences sharedPreferences;
    final LoadingBar loadingBar = new LoadingBar(ProfileActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences=getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");
        String email = sharedPreferences.getString("email","");
        String no_telp =sharedPreferences.getString("notelephone","");
        String getPass= sharedPreferences.getString("password","");

        binding.tvNama.setText(name);
        binding.etUsername.setHint(name);
        binding.etEmail.setHint(email);
        binding.etNoTelp.setHint(no_telp);
        binding.tvEmail.setText(email);
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ProfileActivity.this, MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                overridePendingTransition(0, R.anim.anim_out_left);
                finish();
            }
        });


        binding.btnEdit.setOnClickListener(view -> {
            String emailInputan = binding.etEmail.getText().toString();
            validateEmail(emailInputan);
        });

        binding.btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent keluar = new Intent(ProfileActivity.this, LoginActivity.class);
                keluar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(keluar);
                finish();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        sharedPreferences=getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");
        String email = sharedPreferences.getString("email","");
        String no_telp =sharedPreferences.getString("notelephone","");
        String getPass= sharedPreferences.getString("password","");
        binding.tvNama.setText(name);
        binding.etUsername.setHint(name);
        binding.etEmail.setHint(email);
        binding.etNoTelp.setHint(no_telp);
        binding.tvEmail.setText(email);
    }

    private boolean validateEmail(String emailInputan) {
        if (!emailInputan.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInputan).matches()) {
            ganti(binding.etUsername.getText().toString(),emailInputan, binding.etNoTelp.getText().toString(), binding.etPass.getText().toString());
            return true;
        } if (TextUtils.isEmpty(emailInputan)) {
            ganti(binding.etUsername.getText().toString(),binding.etEmail.getText().toString(), binding.etNoTelp.getText().toString(), binding.etPass.getText().toString());
            return true;
        }
        else {
            Toast.makeText(this, "Email Tidak Sesuai", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void ganti(String username, String email, String noHp, String password) {
        String getPass= sharedPreferences.getString("password","");
        int id=sharedPreferences.getInt("id",0);
        int getid = id;

        RequestProfile requestProfile = new RequestProfile();
        if (username != null && !username.isEmpty()) {
            requestProfile.setName(username);
            loadingBar.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    loadingBar.dismissDialog();
                }
            }, 1000);
        }
        if (email != null && !email.isEmpty()) {
            requestProfile.setEmail(email);
            loadingBar.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    loadingBar.dismissDialog();
                }
            }, 1000);
        }
        if (noHp != null && !noHp.isEmpty()) {
            requestProfile.setNoHp(noHp);
            loadingBar.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    loadingBar.dismissDialog();
                }
            }, 1000);
        }
        if (password != null && !password.isEmpty()) {
            loadingBar.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    loadingBar.dismissDialog();
                }
            }, 1000);
            requestProfile.setPassword(password);
        } else if (TextUtils.isEmpty(password)) {
            loadingBar.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    loadingBar.dismissDialog();
                }
            }, 1000);
            requestProfile.setPassword(getPass);
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
        ApiConfig.service.getprofilebyid(getid, requestProfile).enqueue(new Callback<ResponseProfile>() {
            @Override
            public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                if (response.isSuccessful()) {
                    ResponseProfile responseProfile = response.body();
                    boolean sukses = responseProfile.isStatus();
                    if (sukses) {
                        String name = responseProfile.getProfilUpdate().getName();
                        String email = responseProfile.getProfilUpdate().getEmail();
                        String notelp = responseProfile.getProfilUpdate().getNoHp();
                        String pesanberhasil = responseProfile.getMessage();
                        Toast.makeText(ProfileActivity.this, pesanberhasil, Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", name);
                        editor.putString("email", email);
                        editor.putString("notelephone",notelp);
                        editor.apply();

                        Intent simpanBerhasil = new Intent(ProfileActivity.this,MainActivity.class);
                        simpanBerhasil.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(simpanBerhasil);
                        finish();

                    } else {
                        String pesangagal = responseProfile.getMessage();
                        Toast.makeText(ProfileActivity.this, pesangagal, Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(ProfileActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseProfile> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();

            }
        });

    }
}