package com.sammy.sairamkrishna.iylogic.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.sammy.sairamkrishna.iylogic.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
               SplashActivity.this. startActivity(intent);
               SplashActivity.this. finish();

            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
