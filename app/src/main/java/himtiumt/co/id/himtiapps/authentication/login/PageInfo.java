package himtiumt.co.id.himtiapps.authentication.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import himtiumt.co.id.himtiapps.R;

public class PageInfo extends AppCompatActivity {

    private AdapterScreens adapterScreens;
    private LinearLayout IndicatorScreens;
    private MaterialButton MaterialButton1, MaterialButton2;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_info);

        getSupportActionBar().hide();

        IndicatorScreens = findViewById(R.id.dots_indicator);
        MaterialButton1 = findViewById(R.id.MaterialSkip);
        MaterialButton2 = findViewById(R.id.MaterialNext);

        viewPager2 = findViewById(R.id.ViewPager);
        setupOnItem();

        setupIndicator();
        setIndicatorScreens(0);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setIndicatorScreens(position);
            }
        });

        MaterialButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager2.getCurrentItem() + 1 < adapterScreens.getItemCount()) {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });

        MaterialButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Skipview = new Intent(PageInfo.this, LoginActivity.class);
                startActivity(Skipview);
            }
        });
    }

    private void setupOnItem() {

        List<Item_Screens> item_screens = new ArrayList<>();

        Item_Screens SharingHIMTI = new Item_Screens();
        SharingHIMTI.setTitle("Sharing HIMTI");
        SharingHIMTI.setDescription("Sebuah kegiatan yang dilaksanakan untuk belajar mengajar bidang Informatika bisa di ikuti para anggota dan non anggota");
        SharingHIMTI.setImage(R.drawable.zyro_sharing);

        Item_Screens EventHIMTI = new Item_Screens();
        EventHIMTI.setTitle("Events HIMTI");
        EventHIMTI.setDescription("Salah satu kegiatan yang bisa di ikuti oleh mahasiswa. bebagai kegiatan ada pada Event HIMTI");
        EventHIMTI.setImage(R.drawable.zyro_events);

        Item_Screens AboutHIMTI = new Item_Screens();
        AboutHIMTI.setTitle("Tentang HIMTI");
        AboutHIMTI.setDescription("Berisi tentang seputar sejarah, struktural, keanggotaan dan dokumentasi HIMTI");
        AboutHIMTI.setImage(R.drawable.zyro_aboutorganization);

        Item_Screens AboutCampus = new Item_Screens();
        AboutCampus.setTitle("Info Kampus");
        AboutCampus.setDescription("Memberikan informasi berita terbaru seputar kampus UMT");
        AboutCampus.setImage(R.drawable.zyro_aboutcampus);

        item_screens.add(SharingHIMTI);
        item_screens.add(EventHIMTI);
        item_screens.add(AboutHIMTI);
        item_screens.add(AboutCampus);

        adapterScreens = new AdapterScreens(item_screens);
        viewPager2.setAdapter(adapterScreens);

    }

    private void setupIndicator() {
        ImageView[] Indicators = new ImageView[adapterScreens.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < Indicators.length; i++) {
            Indicators[i] = new ImageView(getApplicationContext());
            Indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.indicator_inactive
            ));
            Indicators[i].setLayoutParams(layoutParams);
            IndicatorScreens.addView(Indicators[i]);
        }
    }

    private void setIndicatorScreens(int index) {
        int childCount = IndicatorScreens.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) IndicatorScreens.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_inactive)
                );
            }
        }
    }

}