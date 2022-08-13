package himtiumt.co.id.himtiapps.sharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import himtiumt.co.id.himtiapps.databinding.ActivityDetailSharingBinding;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.sharing.model.ResponseDetailSharing;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSharingActivity extends AppCompatActivity {

    private ActivityDetailSharingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailSharingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.arrowDetailSharing.setOnClickListener(View ->{
            Intent back = new Intent(this, SharingActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back);
            finish();

        });

        int id = getIntent().getIntExtra("id", 0);

        ApiConfig.service.detailsharing(id).enqueue(new Callback<ResponseDetailSharing>() {
            @Override
            public void onResponse(Call<ResponseDetailSharing> call, Response<ResponseDetailSharing> response) {
                if (response.isSuccessful()){
                    ResponseDetailSharing responseDetailSharing = response.body();
                    String image = responseDetailSharing.getJadwal().getImage();
                    String judul = responseDetailSharing.getJadwal().getTittle();
                    String detail = responseDetailSharing.getJadwal().getDeskripsi();
                    String pemateri = responseDetailSharing.getJadwal().getPemateri();
                    String jadwal = responseDetailSharing.getJadwal().getJadwal();
                    String ruangan = responseDetailSharing.getJadwal().getRuangan();

                    Glide.with(DetailSharingActivity.this)
                            .asBitmap()
                            .load(image)
                            .into(binding.imageDetailSharing);

                    binding.tvJudulDetailSharing.setText(judul);
                    binding.tvDeskripsiDetailSharing.setText(detail);
                    binding.tvJadwalDetailSharing.setText(jadwal);
                    binding.tvPemateriDetailSharing.setText(pemateri);
                    binding.tvRuanganDetailSharing.setText(ruangan);

                }else{
                    Toast.makeText(DetailSharingActivity.this, "Responsse Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailSharing> call, Throwable t) {
                Toast.makeText(DetailSharingActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}