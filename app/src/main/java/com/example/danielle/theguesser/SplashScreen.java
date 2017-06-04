package com.example.danielle.theguesser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity{

    private final int SPLASH_DISPLAY_LENGTH= 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Fala qual é o layout desta página
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



    }
}
