package himtiumt.co.id.himtiapps.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.akademik.AkademikActivity;
import himtiumt.co.id.himtiapps.anggota.AnggotaActivity;
import himtiumt.co.id.himtiapps.anggota.model.DataAnggota;
import himtiumt.co.id.himtiapps.databinding.ActivityMainBinding;
import himtiumt.co.id.himtiapps.dosen.DosenActivity;
import himtiumt.co.id.himtiapps.events.EventActivity;
import himtiumt.co.id.himtiapps.profile.ProfileActivity;
import himtiumt.co.id.himtiapps.sharing.SharingActivity;
import himtiumt.co.id.himtiapps.strukturOrganisasi.StrukturOrganisasiActivity;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.StrukturOrganisasi;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int position = 2;
        editor.putInt("position", position);
        editor.apply();
        String name = sharedPreferences. getString("username", "");
        binding.tvNamaProfile.setText(name);

        binding.foto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profile);
                profile.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                overridePendingTransition(R.anim.anim_in_left,R.anim.anim_no_animasion);

            }
        });

        binding.cvJadwalSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jadwalSharing = new Intent(MainActivity.this, SharingActivity.class);
                startActivity(jadwalSharing);
                finish();
            }
        });

        binding.cvDataAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dataAnggota = new Intent(MainActivity.this, AnggotaActivity.class);
                startActivity(dataAnggota);
                finish();
            }
        });

        binding.cvStrukturAkademik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent strukturAkademik = new Intent(MainActivity.this, StrukturOrganisasiActivity.class);
                startActivity(strukturAkademik);
                finish();
            }
        });

        binding.cvDataDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dataDosen = new Intent(MainActivity.this, DosenActivity.class);
                startActivity(dataDosen);
                finish();
            }
        });

       binding.cvInformasiAkademik.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, AkademikActivity.class);
               startActivity(intent);
               finish();
           }
       });

        binding.cvAcaraHimti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acaraHimti = new Intent(MainActivity.this, EventActivity.class);
                startActivity(acaraHimti);
                finish();
            }
        });



    }
}