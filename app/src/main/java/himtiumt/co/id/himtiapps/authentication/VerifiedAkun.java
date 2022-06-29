package himtiumt.co.id.himtiapps.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.authentication.login.LoginActivity;

public class VerifiedAkun extends AppCompatActivity {

    MaterialButton halamanLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified_akun);

        halamanLogin = findViewById(R.id.MaterialHalamanLogin);

        halamanLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHalamanLogin = new Intent(VerifiedAkun.this, LoginActivity.class);
                startActivity(backHalamanLogin);
            }
        });
    }
}