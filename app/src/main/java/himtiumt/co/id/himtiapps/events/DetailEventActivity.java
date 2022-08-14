package himtiumt.co.id.himtiapps.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import himtiumt.co.id.himtiapps.databinding.ActivityDetailEventBinding;
import himtiumt.co.id.himtiapps.databinding.ActivityEventBinding;
import himtiumt.co.id.himtiapps.events.model.ResponseDetailEvent;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailEventActivity extends AppCompatActivity {

    private ActivityDetailEventBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.arrowDetailEvent.setOnClickListener(view -> {
            Intent back = new Intent(this, EventActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back);
            finish();

        });

        int id = getIntent().getIntExtra("id", 0);

        ApiConfig.service.detailevent(id).enqueue(new Callback<ResponseDetailEvent>() {
            @Override
            public void onResponse(Call<ResponseDetailEvent> call, Response<ResponseDetailEvent> response) {
                if (response.isSuccessful()){
                    ResponseDetailEvent responseDetailEvent = response.body();
                    String image = responseDetailEvent.getDataArtikel().getImage();
                    String judul = responseDetailEvent.getDataArtikel().getTittle();
                    String detail = responseDetailEvent.getDataArtikel().getDeskripsi();
                    String pengisiAcara = responseDetailEvent.getDataArtikel().getPengisiAcra();
                    String jadwal = responseDetailEvent.getDataArtikel().getJadwal();
                    String lokasi = responseDetailEvent.getDataArtikel().getLokasi();

                    Glide.with(DetailEventActivity.this)
                            .asBitmap()
                            .load(image)
                            .into(binding.imageDetailEvent);
                    binding.tvJudulDetailEvent.setText(judul);
                    binding.tvDeskripsiDetailEvent.setText(detail);
                    binding.tvJadwalDetailEvent.setText(jadwal);
                    binding.tvPemateriDetailEvent.setText(pengisiAcara);
                    binding.tvLokasiDetailEvent.setText(lokasi);
                }else {
                    Toast.makeText(DetailEventActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailEvent> call, Throwable t) {
                Toast.makeText(DetailEventActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();

            }
        });
    }
}