package com.example.animal_finder2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);

        MediaPlayer congrats = MediaPlayer.create(MainActivity16.this, R.raw.congrats);
        congrats.start();

    }
}