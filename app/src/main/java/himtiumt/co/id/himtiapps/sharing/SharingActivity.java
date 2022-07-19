package himtiumt.co.id.himtiapps.sharing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.databinding.ActivitySharingBinding;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.sharing.adapter.SharingAdapter;
import himtiumt.co.id.himtiapps.sharing.model.JadwalItem;
import himtiumt.co.id.himtiapps.sharing.model.ResponseSharing;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharingActivity extends AppCompatActivity {

    private ActivitySharingBinding binding;
    private SharingAdapter sharingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recycleview.setHasFixedSize(true);
        binding.recycleview.setLayoutManager(new LinearLayoutManager(this));
        ApiConfig.service.sharing().enqueue(new Callback<ResponseSharing>() {
            @Override
            public void onResponse(Call<ResponseSharing> call, Response<ResponseSharing> response) {
                if (response.isSuccessful()){
                    ResponseSharing responseSharing = response.body();
                    List<JadwalItem> result = responseSharing.getJadwal();
                    sharingAdapter = new SharingAdapter(result, SharingActivity.this);
                    binding.recycleview.setAdapter(sharingAdapter);
                }else {
                    Toast.makeText(SharingActivity.this, "Response Gagal",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSharing> call, Throwable t) {
                Toast.makeText(SharingActivity.this, "Periksa Jaringan Anda",
                        Toast.LENGTH_SHORT).show();

            }
        });

    }
}