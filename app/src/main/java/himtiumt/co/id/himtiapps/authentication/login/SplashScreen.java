package himtiumt.co.id.himtiapps.authentication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import himtiumt.co.id.himtiapps.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        // Menghilangkan ActionBar
        setContentView(R.layout.activity_splash_screen2);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(getApplication(),PageInfo.class));
                finish();
            }
        },2000L); // 2000 L = 2 Detik
    }
}