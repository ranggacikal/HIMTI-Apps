package himtiumt.co.id.himtiapps.dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.databinding.ActivityDosenBinding;
import himtiumt.co.id.himtiapps.dosen.adapter.DosenAdapter;
import himtiumt.co.id.himtiapps.home.HomeActivity;
import himtiumt.co.id.himtiapps.model.DosenItem;
import himtiumt.co.id.himtiapps.model.ResponseAllDosen;
import himtiumt.co.id.himtiapps.model.ResponseDosen;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenActivity extends AppCompatActivity {

    ActivityDosenBinding binding;
    DosenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDosenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        binding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(DosenActivity.this, HomeActivity.class);
                startActivity(back);
            }
        });

        setUpSearch();
        setUpDataDosen();
    }

    private void setUpDataDosen() {
        ApiConfig.service.AllDosen().enqueue(new Callback<ResponseAllDosen>() {
            @Override
            public void onResponse(Call<ResponseAllDosen> call, Response<ResponseAllDosen> response) {
                if (response.isSuccessful()){
                    ResponseAllDosen responseAllDosen = response.body();
                    List<DosenItem> result = responseAllDosen.getDosen();
                    adapter = new DosenAdapter(result, DosenActivity.this);
                    binding.recyclerview.setAdapter(adapter);
                } else{
                    Toast.makeText(DosenActivity.this, "Respons Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAllDosen> call, Throwable t) {
                Toast.makeText(DosenActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpSearch() {
        binding.tidSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(binding.tidSearch.getText().toString());
            }
        });
    }

    private void search(String search) {
        ApiConfig.service.getDosen(search).enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {
                if (response.isSuccessful()){
                    ResponseDosen responseDosen = response.body();
                    List<DosenItem> result = responseDosen.getDosen();
                    adapter = new DosenAdapter(result, DosenActivity.this);
                    binding.recyclerview.setAdapter(adapter);
                } else {
                    Toast.makeText(DosenActivity.this, "Respons Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDosen> call, Throwable t) {
                Toast.makeText(DosenActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}