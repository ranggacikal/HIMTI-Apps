package himtiumt.co.id.himtiapps.authentication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import himtiumt.co.id.himtiapps.R;

public class LoginActivity extends AppCompatActivity {

    TextView IndexOne, IndexTwo, IndexTree, IndexFour;
    TextInputLayout MaterialEmail, MaterialPassword, MaterialLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        IndexOne = findViewById(R.id.tv_masuk_himti);
        IndexTwo = findViewById(R.id.tv_title_login);
        IndexTree = findViewById(R.id.txtLupaPassword);
        IndexFour = findViewById(R.id.txt_Akun1);
        MaterialEmail = findViewById(R.id.MateriaEmail);
        MaterialPassword = findViewById(R.id.MateriaPassword);


        IndexTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}