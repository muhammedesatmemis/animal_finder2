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

public class MainActivity6 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=5;
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
        imageView15 = (ImageView) findViewById(R.id.imageView15);

        MediaPlayer monkey = MediaPlayer.create(MainActivity6.this, R.raw.monkey);
        monkey.start();


        new CountDownTimer(23000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity6.this);
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
                        Toast.makeText(MainActivity6.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity6.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView13.setVisibility(View.INVISIBLE);
                imageView14.setVisibility(View.INVISIBLE);
                imageView15.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity6.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity6.this, MainActivity7.class);
                startActivity(intent);
            }
        },3000);
    }
}