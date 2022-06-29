package himtiumt.co.id.himtiapps.akademik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

import himtiumt.co.id.himtiapps.R;

public class AkademikActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademik);
        webView = findViewById(R.id.webView);
        webSettings = webView.getSettings();

//        Aktifasi javascript
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://informatika.ft-umt.ac.id/");

    }
}