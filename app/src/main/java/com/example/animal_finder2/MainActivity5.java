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

public class MainActivity5 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=4;
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);

        MediaPlayer bird = MediaPlayer.create(MainActivity5.this, R.raw.bird);
        bird.start();


        new CountDownTimer(23000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
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
                        Toast.makeText(MainActivity5.this, "Game Over", Toast.LENGTH_SHORT).show();
                        imageView10.setVisibility(View.INVISIBLE);
                        imageView11.setVisibility(View.INVISIBLE);
                        imageView12.setVisibility(View.INVISIBLE);
                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity5.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView10.setVisibility(View.INVISIBLE);
                imageView11.setVisibility(View.INVISIBLE);
                imageView12.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity5.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(intent);
            }
        },3000);
    }
}