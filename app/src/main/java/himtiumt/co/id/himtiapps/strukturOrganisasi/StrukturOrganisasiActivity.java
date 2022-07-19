package himtiumt.co.id.himtiapps.strukturOrganisasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.List;

import himtiumt.co.id.himtiapps.databinding.ActivityStrukturOrganisasiBinding;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.strukturOrganisasi.adapter.StrukturOrganisasiAdapter;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.PengurusItem;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.ResponseStrukturOrganisasi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StrukturOrganisasiActivity extends AppCompatActivity {

    private ActivityStrukturOrganisasiBinding binding ;
    private StrukturOrganisasiAdapter strukturOrganisasiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityStrukturOrganisasiBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

        binding.rvStrukturOrganisasi.setHasFixedSize(true);
        GridLayoutManager gridLayoutManagerBPH = new GridLayoutManager(StrukturOrganisasiActivity.this,
                2, GridLayoutManager.VERTICAL, false);
        binding.rvStrukturOrganisasi.setLayoutManager(gridLayoutManagerBPH);

        ApiConfig.service.getStrukturOrganisasi().enqueue(new Callback<ResponseStrukturOrganisasi>() {
            @Override
            public void onResponse(Call<ResponseStrukturOrganisasi> call, Response<ResponseStrukturOrganisasi> response) {
                if (response.isSuccessful()) {
                    ResponseStrukturOrganisasi responseStrukturOrganisasi= response.body();
                    List<PengurusItem> result = responseStrukturOrganisasi.getPengurus();
                    strukturOrganisasiAdapter= new StrukturOrganisasiAdapter(StrukturOrganisasiActivity.this, result);
                    binding.rvStrukturOrganisasi.setAdapter(strukturOrganisasiAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseStrukturOrganisasi> call, Throwable t) {

            }
        });



    }

}