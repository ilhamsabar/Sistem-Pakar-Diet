package com.example.ilhamsabar.cobadiet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ilham sabar on 2/20/2016.
 */
public class Splashscreen extends AppCompatActivity {

    //waktu splash screen
    private static int splashInterval = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {
                                          Intent i = new Intent(Splashscreen.this, MainActivity.class);
                                          startActivity(i);
                                          Splashscreen.this.finish();
                                      }
                                  },
                splashInterval);
    }
}
