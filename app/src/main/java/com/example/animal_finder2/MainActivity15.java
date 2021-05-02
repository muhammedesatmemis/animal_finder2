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

public class MainActivity15 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView55;
    ImageView imageView56;
    ImageView imageView57;
    ImageView imageView58;
    ImageView imageView59;
    ImageView imageView60;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=14;
        imageView55 = (ImageView) findViewById(R.id.imageView55);
        imageView56 = (ImageView) findViewById(R.id.imageView56);
        imageView57 = (ImageView) findViewById(R.id.imageView57);
        imageView58 = (ImageView) findViewById(R.id.imageView58);
        imageView59 = (ImageView) findViewById(R.id.imageView59);
        imageView60 = (ImageView) findViewById(R.id.imageView60);

        MediaPlayer chicken = MediaPlayer.create(MainActivity15.this, R.raw.chicken);
        chicken.start();


        new CountDownTimer(16000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity15.this);
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
                        Toast.makeText(MainActivity15.this, "Game Over", Toast.LENGTH_SHORT).show();
                        imageView55.setVisibility(View.INVISIBLE);
                        imageView56.setVisibility(View.INVISIBLE);
                        imageView57.setVisibility(View.INVISIBLE);
                        imageView58.setVisibility(View.INVISIBLE);
                        imageView59.setVisibility(View.INVISIBLE);
                        imageView60.setVisibility(View.INVISIBLE);

                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity15.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView55.setVisibility(View.INVISIBLE);
                imageView56.setVisibility(View.INVISIBLE);
                imageView57.setVisibility(View.INVISIBLE);
                imageView58.setVisibility(View.INVISIBLE);
                imageView59.setVisibility(View.INVISIBLE);
                imageView60.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity15.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity15.this, MainActivity16.class);
                startActivity(intent);
            }
        },3000);
    }
}