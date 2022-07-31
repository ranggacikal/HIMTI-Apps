package himtiumt.co.id.himtiapps.anggota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import himtiumt.co.id.himtiapps.UI.LoadingBar;
import himtiumt.co.id.himtiapps.anggota.adapter.AnggotaAdapter;
import himtiumt.co.id.himtiapps.anggota.adapter.AnggotaAngkatanAdapter;
import himtiumt.co.id.himtiapps.anggota.model.AnggotaItem;
import himtiumt.co.id.himtiapps.anggota.model.ResponseAnggotaAll;
import himtiumt.co.id.himtiapps.anggota.model.ResponseAngkatanAnggota;
import himtiumt.co.id.himtiapps.anggota.model.ResponseSearchAnggota;
import himtiumt.co.id.himtiapps.databinding.ActivityAnggotaBinding;
import himtiumt.co.id.himtiapps.home.MainActivity;
import himtiumt.co.id.himtiapps.network.ApiConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnggotaActivity extends AppCompatActivity {

    private ActivityAnggotaBinding binding;
    private AnggotaAdapter anggotaAdapter;
    private AnggotaAngkatanAdapter anggotaAngkatanAdapter;
    final LoadingBar loadingBar = new LoadingBar(AnggotaActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityAnggotaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvDataAnggota.setHasFixedSize(true);
        binding.rvDataAnggota.setLayoutManager(new LinearLayoutManager(this));

        binding.ivBackArrow.setOnClickListener(view -> {
            Intent back = new Intent(AnggotaActivity.this, MainActivity.class);
            startActivity(back);
            finish();
        });

        setUpDataDosen();

        setupSpinner();

        setUpSearch();

    }

    private void setUpDataDosen() {
        ApiConfig.service.getAnggotaAll().enqueue(new Callback<ResponseAnggotaAll>() {
            @Override
            public void onResponse(Call<ResponseAnggotaAll> call, Response<ResponseAnggotaAll> response) {
                if (response.isSuccessful()) {
                    ResponseAnggotaAll responseAnggotaAll = response.body();
                    List<AnggotaItem> result = responseAnggotaAll.getAnggota();
                    anggotaAdapter = new AnggotaAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAdapter);
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAnggotaAll> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpSearch() {
        binding.ivSearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(binding.tidSearch.getText().toString());
                loadingBar.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingBar.dismissDialog();
                    }
                }, 0500);
                binding.spinTahunAngkatan.setSelection(0);
            }

            private void search(String search) {
                Log.d("test", "search: " + search);

                ApiConfig.service.getSearchAnggota(search).enqueue(new Callback<ResponseSearchAnggota>() {
                    @Override
                    public void onResponse(Call<ResponseSearchAnggota> call, Response<ResponseSearchAnggota> response) {
                        if (response.isSuccessful()) {
                            ResponseSearchAnggota responseSearchAnggota = response.body();
                            List<AnggotaItem> result = responseSearchAnggota.getAnggota();
                            anggotaAdapter = new AnggotaAdapter(result, AnggotaActivity.this);
                            binding.rvDataAnggota.setAdapter(anggotaAdapter);
                        } else {
                            Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseSearchAnggota> call, Throwable t) {
                        Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void setupSpinner() {
        ArrayList<String> tahunAngkatan = new ArrayList<>();
        tahunAngkatan.add("Pilih Angkatan");
        tahunAngkatan.add("Semua Angkatan");
        tahunAngkatan.add("2021");
        tahunAngkatan.add("2020");
        tahunAngkatan.add("2019");
        tahunAngkatan.add("2018");
        tahunAngkatan.add("2017");
        tahunAngkatan.add("2016");
        tahunAngkatan.add("2015");
        tahunAngkatan.add("2014");
        tahunAngkatan.add("2013");
        tahunAngkatan.add("2012");
        tahunAngkatan.add("2011");

        ArrayAdapter tahunAngkatanAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tahunAngkatan);
        binding.spinTahunAngkatan.setAdapter(tahunAngkatanAdapter);

        binding.spinTahunAngkatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else if (position == 1) {
                    AllList();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 2) {
                    sortBy2021();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 3) {
                    sortBy2020();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 4) {
                    sortBy2019();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 5) {
                    sortBy2018();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 6) {
                    sortBy2017();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 7) {
                    sortBy2016();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 8) {
                    sortBy2015();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 9) {
                    sortBy2014();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 10) {
                    sortBy2013();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 11) {
                    sortBy2012();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                } else if (position == 12) {
                    sortBy2011();
                    loadingBar.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.dismissDialog();
                        }
                    }, 0500);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void sortBy2011() {
        String angkatan = "2";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2012() {
        String angkatan = "3";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2013() {
        String angkatan = "1";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2014() {
        String angkatan = "2";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2015() {
        String angkatan = "3";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2016() {
        String angkatan = "1";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2017() {
        String angkatan = "2";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2018() {
        String angkatan = "3";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2019() {
        String angkatan = "1";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2020() {
        String angkatan = "2";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sortBy2021() {
        String angkatan = "3";

        ApiConfig.service.getAngkatanAnggota(angkatan).enqueue(new Callback<ResponseAngkatanAnggota>() {
            @Override
            public void onResponse(Call<ResponseAngkatanAnggota> call, Response<ResponseAngkatanAnggota> response) {
                if (response.isSuccessful()) {
                    ResponseAngkatanAnggota responseAngkatanAnggota = response.body();
                    List<AnggotaItem> result = responseAngkatanAnggota.getAnggota();
                    anggotaAngkatanAdapter = new AnggotaAngkatanAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAngkatanAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAngkatanAnggota> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AllList() {
        ApiConfig.service.getAnggotaAll().enqueue(new Callback<ResponseAnggotaAll>() {
            @Override
            public void onResponse(Call<ResponseAnggotaAll> call, Response<ResponseAnggotaAll> response) {
                if (response.isSuccessful()) {
                    ResponseAnggotaAll responseAnggotaAll = response.body();
                    List<AnggotaItem> result = responseAnggotaAll.getAnggota();
                    anggotaAdapter = new AnggotaAdapter(result, AnggotaActivity.this);
                    binding.rvDataAnggota.setAdapter(anggotaAdapter);
                    binding.tidSearch.getText().clear();
                } else {
                    Toast.makeText(AnggotaActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAnggotaAll> call, Throwable t) {
                Toast.makeText(AnggotaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}