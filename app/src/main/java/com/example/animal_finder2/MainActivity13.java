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

public class MainActivity13 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView43;
    ImageView imageView44;
    ImageView imageView45;
    ImageView imageView46;
    ImageView imageView47;
    ImageView imageView48;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=12;
        imageView43 = (ImageView) findViewById(R.id.imageView43);
        imageView44 = (ImageView) findViewById(R.id.imageView44);
        imageView45 = (ImageView) findViewById(R.id.imageView45);
        imageView46 = (ImageView) findViewById(R.id.imageView46);
        imageView47 = (ImageView) findViewById(R.id.imageView47);
        imageView48 = (ImageView) findViewById(R.id.imageView48);

        MediaPlayer snake = MediaPlayer.create(MainActivity13.this, R.raw.snake);
        snake.start();


        new CountDownTimer(16000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity13.this);
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
                        Toast.makeText(MainActivity13.this, "Game Over", Toast.LENGTH_SHORT).show();
                        imageView43.setVisibility(View.INVISIBLE);
                        imageView44.setVisibility(View.INVISIBLE);
                        imageView45.setVisibility(View.INVISIBLE);
                        imageView46.setVisibility(View.INVISIBLE);
                        imageView47.setVisibility(View.INVISIBLE);
                        imageView48.setVisibility(View.INVISIBLE);

                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity13.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView43.setVisibility(View.INVISIBLE);
                imageView44.setVisibility(View.INVISIBLE);
                imageView45.setVisibility(View.INVISIBLE);
                imageView46.setVisibility(View.INVISIBLE);
                imageView47.setVisibility(View.INVISIBLE);
                imageView48.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity13.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity13.this, MainActivity14.class);
                startActivity(intent);
            }
        },3000);
    }
}