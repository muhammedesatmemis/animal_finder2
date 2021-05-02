package com.example.animal_finder2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView22;
    ImageView imageView23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=7;
        imageView20 = (ImageView) findViewById(R.id.imageView20);
        imageView21 = (ImageView) findViewById(R.id.imageView21);
        imageView22 = (ImageView) findViewById(R.id.imageView22);
        imageView23 = (ImageView) findViewById(R.id.imageView23);

        MediaPlayer cat = MediaPlayer.create(MainActivity8.this, R.raw.cat);
        cat.start();


        new CountDownTimer(20000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity8.this);
                alert.setTitle("TIME OVER");
                alert.setMessage("Do you want to restart?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity8.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity8.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView20.setVisibility(View.INVISIBLE);
                imageView21.setVisibility(View.INVISIBLE);
                imageView22.setVisibility(View.INVISIBLE);
                imageView23.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity8.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity8.this, MainActivity9.class);
                startActivity(intent);
            }
        },3000);
    }
}