package com.example.chan.localechangetest;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chan.localechangetest.common.PreferencesManager;
import com.example.chan.localechangetest.common.helper.LocaleHelper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button engBtn;

    private Button mmBtn;

    private TextView greetingTextView;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerUIs();

        registerEvents();

        /*String languageCode = PreferencesManager.getActiveLanguange(this);
        if (null != languageCode) {
            changeLocale(languageCode);
        }*/
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
    }

    private void changeLocale(String languageCode) {

        LocaleHelper.setLocale(this, languageCode);
        Intent refresh = new Intent(this, this.getClass());
        startActivity(refresh);
        finish();
    }
}
