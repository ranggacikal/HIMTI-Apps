package himtiumt.co.id.himtiapps.strukturOrganisasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.databinding.ActivityStrukturOrganisasiBinding;
import himtiumt.co.id.himtiapps.strukturOrganisasi.adapter.StrukturOrganisasiAdapter;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.StrukturOrganisasi;

public class StrukturOrganisasiActivity extends AppCompatActivity {

    private ActivityStrukturOrganisasiBinding binding ;
    private List<StrukturOrganisasi> strukturOrganisasiListBPH;
    private  List<StrukturOrganisasi> strukturOrganisasiListKadiv;
    private StrukturOrganisasiAdapter strukturOrganisasiAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityStrukturOrganisasiBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

        setupListBPH();

        binding.rvStrukturOrganisasiBPH.setHasFixedSize(true);
        GridLayoutManager gridLayoutManagerBPH = new GridLayoutManager(StrukturOrganisasiActivity.this,
                2, GridLayoutManager.VERTICAL, false);
        binding.rvStrukturOrganisasiBPH.setLayoutManager(gridLayoutManagerBPH);

        setupListKadiv();

        binding.rvStrukturOrganisasiKadiv.setHasFixedSize(true);
        GridLayoutManager gridLayoutManagerKadiv = new GridLayoutManager(StrukturOrganisasiActivity.this,
                3, GridLayoutManager.VERTICAL, false);
        binding.rvStrukturOrganisasiKadiv.setLayoutManager(gridLayoutManagerKadiv);




    }

    private void setupListKadiv() {
        strukturOrganisasiListKadiv = new ArrayList<>();

        strukturOrganisasiListKadiv.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Aji Saipudin", "1955201057", "Ketua Divisi SDM"));
        strukturOrganisasiListKadiv.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Nur Fakhri Arif", "1955201193", "Ketua Divisi Organisasi"));
        strukturOrganisasiListKadiv.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Kaimdin Latupuno", "1955201027", "ketua Divisi Kominfo"));
        strukturOrganisasiListKadiv.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Rif'an Fathurrohman", "1955201205", "Ketua Divisi Litbang"));
        strukturOrganisasiListKadiv.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Rendi Ferdian", "1955201205", "Ketua Divisi Dana Usaha"));


        strukturOrganisasiAdapter = new StrukturOrganisasiAdapter(StrukturOrganisasiActivity.this, strukturOrganisasiListKadiv);
        binding.rvStrukturOrganisasiKadiv.setAdapter(strukturOrganisasiAdapter);
    }

    private void setupListBPH() {
        strukturOrganisasiListBPH = new ArrayList<>();

        strukturOrganisasiListBPH.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Rafi Ramadhan", "1955201124", "Bupati"));
        strukturOrganisasiListBPH.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Khoirul Fajar aswar", "1955201071", "Wakil Bupati"));
        strukturOrganisasiListBPH.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Nadila Pilar Kencana", "1955201171", "Sekretaris"));
        strukturOrganisasiListBPH.add(new StrukturOrganisasi(R.drawable.ic_launcher_background, "Terry Antikasari", "1955201221", "Bendahara"));

        strukturOrganisasiAdapter = new StrukturOrganisasiAdapter(StrukturOrganisasiActivity.this, strukturOrganisasiListBPH);
        binding.rvStrukturOrganisasiBPH.setAdapter(strukturOrganisasiAdapter);
    }
}