package himtiumt.co.id.himtiapps.authentication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.home.MainActivity;

public class SplashScreen extends AppCompatActivity {

    // Time SplashScreen
    private static int SPLASH_TIME_OUT = 2000;

    // Hook
    ImageView splashScreen;
    SharedPreferences sharedPreferences;

    // Animation
    Animation animationScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.apply();
        int loginPage = 1;
        int mainPage = 2;
        int position = sharedPreferences.getInt("position", 0);
        if (loginPage == position) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent SplashScreen = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(SplashScreen);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else if (mainPage == position) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent SplashScreen = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(SplashScreen);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent SplashScreen = new Intent(SplashScreen.this, PageInfo.class);
                    startActivity(SplashScreen);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }

        // Animations
        animationScreen = AnimationUtils.loadAnimation(this,R.anim.animation);

        // Hooks
        splashScreen = findViewById(R.id.screen);

        // Setting Animation
        splashScreen.setAnimation(animationScreen);

    }
}