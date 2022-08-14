package himtiumt.co.id.himtiapps.akademik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.databinding.ActivityAkademikBinding;
import himtiumt.co.id.himtiapps.home.MainActivity;

public class AkademikActivity extends AppCompatActivity {

    ActivityAkademikBinding binding;

    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAkademikBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AkademikActivity.this, MainActivity.class);
                back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back);
                finish();
            }
        });

        webSettings = binding.webView.getSettings();

//        Aktifasi javascript
        webSettings.setJavaScriptEnabled(true);

        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl("https://informatika.ft-umt.ac.id/");

    }
}