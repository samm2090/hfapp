package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hazfutbol.hfapp.R;



public class SplashActivity extends Activity {

    private Context myContext;
    private Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = getApplicationContext();
        setContentView(R.layout.activity_splash);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        splashThread = new Thread(){
            @Override
            public void run(){
                try {
                    int waited = 0;
                    while (waited < 2000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                    // do nothings
                } finally {
                    finish();
                    Intent intent = new Intent(myContext,CarouselPresentationActivity.class);
                    startActivity(intent);
                }
            }

        };
        splashThread.start();
    }
}
