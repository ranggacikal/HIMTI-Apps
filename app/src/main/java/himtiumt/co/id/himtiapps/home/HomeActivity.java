package himtiumt.co.id.himtiapps.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import himtiumt.co.id.himtiapps.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Eliminate ActionBar
        getSupportActionBar().hide();
    }
}