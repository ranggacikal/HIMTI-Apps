package himtiumt.co.id.himtiapps.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.databinding.ActivityEventBinding;
import himtiumt.co.id.himtiapps.events.adapter.EventAdapter;
import himtiumt.co.id.himtiapps.events.model.DataArtikelItem;
import himtiumt.co.id.himtiapps.events.model.ResponseEvent;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.sharing.adapter.SharingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import himtiumt.co.id.himtiapps.databinding.ActivityEventBinding;
import himtiumt.co.id.himtiapps.events.adapter.EventAdapter;
import himtiumt.co.id.himtiapps.events.model.DataArtikelItem;
import himtiumt.co.id.himtiapps.events.model.ResponseEvent;
import himtiumt.co.id.himtiapps.home.MainActivity;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import himtiumt.co.id.himtiapps.sharing.SharingActivity;
import himtiumt.co.id.himtiapps.sharing.adapter.SharingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {

    private ActivityEventBinding binding;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.arrowJadwalEvent.setOnClickListener(View ->{
            Intent back = new Intent(this, MainActivity.class);
            back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back);
            finish();

        });

        binding.recycleviewEvent.setHasFixedSize(true);
        binding.recycleviewEvent.setLayoutManager(new LinearLayoutManager(this));
        ApiConfig.service.event().enqueue(new Callback<ResponseEvent>() {
            @Override
            public void onResponse(Call<ResponseEvent> call, Response<ResponseEvent> response) {
                if (response.isSuccessful()){
                    ResponseEvent responseEvent = response.body();
                    List<DataArtikelItem> result = responseEvent.getDataArtikel();
                    eventAdapter = new EventAdapter(result, EventActivity.this);
                    binding.recycleviewEvent.setAdapter(eventAdapter);
                }else{
                    Toast.makeText(EventActivity.this, "Response Gagal",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseEvent> call, Throwable t) {
                Toast.makeText(EventActivity.this, "Periksa Jarinan Anda",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}