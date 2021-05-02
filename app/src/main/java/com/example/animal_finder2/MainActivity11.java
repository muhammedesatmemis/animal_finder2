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

public class MainActivity11 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView33;
    ImageView imageView34;
    ImageView imageView35;
    ImageView imageView36;
    ImageView imageView37;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=10;
        imageView33 = (ImageView) findViewById(R.id.imageView33);
        imageView34 = (ImageView) findViewById(R.id.imageView34);
        imageView35 = (ImageView) findViewById(R.id.imageView35);
        imageView36 = (ImageView) findViewById(R.id.imageView36);
        imageView37 = (ImageView) findViewById(R.id.imageView37);

        MediaPlayer frog = MediaPlayer.create(MainActivity11.this, R.raw.frog);
        frog.start();


        new CountDownTimer(18000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity11.this);
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
                        Toast.makeText(MainActivity11.this, "Game Over", Toast.LENGTH_SHORT).show();
                        imageView33.setVisibility(View.INVISIBLE);
                        imageView34.setVisibility(View.INVISIBLE);
                        imageView35.setVisibility(View.INVISIBLE);
                        imageView36.setVisibility(View.INVISIBLE);
                        imageView37.setVisibility(View.INVISIBLE);

                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity11.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView33.setVisibility(View.INVISIBLE);
                imageView34.setVisibility(View.INVISIBLE);
                imageView35.setVisibility(View.INVISIBLE);
                imageView36.setVisibility(View.INVISIBLE);
                imageView37.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity11.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity11.this, MainActivity12.class);
                startActivity(intent);
            }
        },3000);
    }
}