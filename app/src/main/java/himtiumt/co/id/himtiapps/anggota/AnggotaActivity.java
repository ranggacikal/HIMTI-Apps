package himtiumt.co.id.himtiapps.anggota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.anggota.adapter.AnggotaAdapter;
import himtiumt.co.id.himtiapps.anggota.model.DataAnggota;
import himtiumt.co.id.himtiapps.databinding.ActivityAnggotaBinding;

public class AnggotaActivity extends AppCompatActivity {
private ActivityAnggotaBinding binding;

    private  List<DataAnggota> dataAnggotaList2021;
    private  List<DataAnggota> dataAnggotaList2020;
    private  List<DataAnggota> dataAnggotaList2019;
    private  List<DataAnggota> dataAnggotaList2018;
    private  List<DataAnggota> dataAnggotaList2017;
    private  List<DataAnggota> dataAnggotaList2016;
    private  List<DataAnggota> dataAnggotaList2015;
    private  List<DataAnggota> dataAnggotaList2014;
    private  List<DataAnggota> dataAnggotaList2013;
    private  List<DataAnggota> dataAnggotaList2012;
    private  List<DataAnggota> dataAnggotaList2011;
    private AnggotaAdapter DataAnggotaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityAnggotaBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_anggota);

        binding.rvDataAnggota.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AnggotaActivity.this,
                3, GridLayoutManager.VERTICAL, false);
        binding.rvDataAnggota.setLayoutManager(gridLayoutManager);

        setupList2021();

        setupList2020();

        setupList2019();

        setupList2018();

        setupList2017();

        setupList2016();

        setupList2015();

        setupList2014();

        setupList2013();

        setupList2012();

        setupList2011();

        setupSpinner();


    }

    private void setupSpinner() {
        ArrayList<String> tahunAngkatan = new ArrayList<>();
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
                    sortBy2021();
                } else if (position == 1) {
                    sortBy2020();
                } else if (position == 2) {
                    sortBy2019();
                } else if (position == 3) {
                    sortBy2018();
                } else if (position == 4) {
                    sortBy2017();
                } else if (position == 5) {
                    sortBy2016();
                } else if (position == 6) {
                    sortBy2015();
                } else if (position == 7) {
                    sortBy2014();
                } else if (position == 8) {
                    sortBy2013();
                } else if (position == 9) {
                    sortBy2012();
                } else if (position == 10) {
                    sortBy2011();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void sortBy2011() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2011, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2012() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2012, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2013() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2013, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2014() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2014, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2015() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2015, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2016() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2016, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2017() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2017, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2018() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2018, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2019() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2019, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2020() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2020, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void sortBy2021() {
        DataAnggotaAdapter = new AnggotaAdapter(dataAnggotaList2021, AnggotaActivity.this);
        binding.rvDataAnggota.setAdapter(DataAnggotaAdapter);
    }

    private void setupList2021() {
        dataAnggotaList2021 = new ArrayList<>();

        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));
        dataAnggotaList2021.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2021));


    }

    private void setupList2020() {
        dataAnggotaList2020 = new ArrayList<>();

        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
        dataAnggotaList2020.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2020));
    }

    private void setupList2019() {
        dataAnggotaList2019 = new ArrayList<>();

        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
        dataAnggotaList2019.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2019));
    }

    private void setupList2018() {
        dataAnggotaList2018 = new ArrayList<>();

        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
        dataAnggotaList2018.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2018));
    }

    private void setupList2017() {
        dataAnggotaList2017 = new ArrayList<>();

        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
        dataAnggotaList2017.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2017));
    }

    private void setupList2016() {
        dataAnggotaList2016 = new ArrayList<>();

        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
        dataAnggotaList2016.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2016));
    }

    private void setupList2015() {
        dataAnggotaList2015 = new ArrayList<>();

        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
        dataAnggotaList2015.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2015));
    }

    private void setupList2014() {
        dataAnggotaList2014 = new ArrayList<>();

        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
        dataAnggotaList2014.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2014));
    }

    private void setupList2013() {
        dataAnggotaList2013 = new ArrayList<>();

        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
        dataAnggotaList2013.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2013));
    }

    private void setupList2012() {
        dataAnggotaList2012 = new ArrayList<>();

        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
        dataAnggotaList2012.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2012));
    }

    private void setupList2011() {
        dataAnggotaList2011 = new ArrayList<>();

        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
        dataAnggotaList2011.add(new DataAnggota(R.drawable.ic_launcher_background, "Mohammad Dimas Noufal",
                "2155201112", 2011));
    }




}