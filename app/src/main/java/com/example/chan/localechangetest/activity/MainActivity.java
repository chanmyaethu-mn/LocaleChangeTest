package com.example.chan.localechangetest.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chan.localechangetest.R;
import com.example.chan.localechangetest.common.helper.LocaleHelper;

public class MainActivity extends AppCompatActivity {

    private Button engBtn;

    private Button mmBtn;

    private TextView hwTextView;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.app_name));

        registerUIs();

        registerEvents();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    private void registerEvents() {
        engBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocale("en");
            }
        });

        mmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocale("mm");
            }
        });
    }

    private void registerUIs() {
        engBtn = findViewById(R.id.en_btn);
        mmBtn = findViewById(R.id.mm_btn);
        hwTextView = findViewById(R.id.hw_textview);
    }

    private void changeLocale(String languageCode) {

        Context context = LocaleHelper.setLocale(this, languageCode);
        Resources resources = context.getResources();

        engBtn.setText(resources.getString(R.string.eng_btn_name));
        mmBtn.setText(resources.getString(R.string.mm_btn_name));
        hwTextView.setText(resources.getString(R.string.greeting));
        setTitle(resources.getString(R.string.app_name));

        /*Intent refresh = new Intent(this, this.getClass());
        startActivity(refresh);
        finish();*/
    }
}
