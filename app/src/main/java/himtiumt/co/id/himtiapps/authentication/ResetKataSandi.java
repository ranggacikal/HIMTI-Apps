package himtiumt.co.id.himtiapps.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.authentication.login.LoginActivity;

public class ResetKataSandi extends AppCompatActivity {

    ImageView returnApps;
    MaterialButton materialSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_kata_sandi);

        returnApps = findViewById(R.id.ClickReturn);
        materialSimpan = findViewById(R.id.MaterialSimpan);

        materialSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent simpanPerubahan = new Intent(ResetKataSandi.this, VerifiedAkun.class);
                startActivity(simpanPerubahan);
            }
        });

        returnApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backLogin = new Intent(ResetKataSandi.this, LoginActivity.class);
                startActivity(backLogin);
            }
        });


    }
}