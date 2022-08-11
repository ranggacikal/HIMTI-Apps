package himtiumt.co.id.himtiapps.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import himtiumt.co.id.himtiapps.authentication.login.LoginActivity;
import himtiumt.co.id.himtiapps.databinding.ActivityProfileBinding;
import himtiumt.co.id.himtiapps.home.MainActivity;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.profile.model.RequestProfile;
import himtiumt.co.id.himtiapps.profile.model.ResponseProfile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences=getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String email = sharedPreferences.getString("email","");
        String no_telp =sharedPreferences.getString("no_telp","");
        binding.tvNama.setText(name);
        binding.etUsername.setHint(name);
        binding.etEmail.setHint(email);
        binding.etNoTelp.setHint(no_telp);
        binding.tvEmail.setText(email);
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(home);
            }
        });


        binding.btnEdit.setOnClickListener(view -> {
            ganti(binding.etUsername.getText().toString(),binding.etNoTelp.getText().toString(),binding.etPass.getText().toString());

        });
        binding.btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent keluar = new Intent(ProfileActivity.this, LoginActivity.class);
                keluar.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(keluar);
                finish();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        sharedPreferences=getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String email = sharedPreferences.getString("email","");
        String no_telp =sharedPreferences.getString("no_telp","");
        binding.tvNama.setText(name);
        binding.etUsername.setHint(name);
        binding.etEmail.setHint(email);
        binding.etNoTelp.setHint(no_telp);
        binding.tvEmail.setText(email);
    }

    private void ganti(String username, String noHp, String password) {
        int id=sharedPreferences.getInt("id",0);
        int getid = id;

        RequestProfile requestProfile = new RequestProfile();
        if (username != null && !username.isEmpty()) {
            requestProfile.setName(username);
        } if (noHp != null && !noHp.isEmpty()) {
            requestProfile.setNoHp(noHp);
        }
        if (password != null && !password.isEmpty()) {
            requestProfile.setPassword(password);
        } else {

        }
        ApiConfig.service.getprofilebyid(getid, requestProfile).enqueue(new Callback<ResponseProfile>() {
            @Override
            public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                if (response.isSuccessful()) {
                    ResponseProfile responseProfile = response.body();
                    boolean sukses = responseProfile.isStatus();
                    if (sukses) {
                        String name = responseProfile.getProfilUpdate().getName();
                        String noHp = responseProfile.getProfilUpdate().getNoHp();
                        String pesanberhasil = responseProfile.getMessage();
                        Toast.makeText(ProfileActivity.this, pesanberhasil, Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name", name);
                        editor.putString("no_telp",noHp);
                        editor.apply();

                        Intent simpanBerhasil = new Intent(ProfileActivity.this,MainActivity.class);
                        startActivity(simpanBerhasil);
                        finish();

                    } else {
                        String pesangagal = responseProfile.getMessage();
                        Toast.makeText(ProfileActivity.this, pesangagal, Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(ProfileActivity.this, "respongagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseProfile> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "periksa jaringan anda", Toast.LENGTH_SHORT).show();

            }
        });

    }
}