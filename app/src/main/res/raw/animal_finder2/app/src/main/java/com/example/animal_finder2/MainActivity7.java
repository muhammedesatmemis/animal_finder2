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

public class MainActivity7 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=6;
        imageView16 = (ImageView) findViewById(R.id.imageView16);
        imageView17 = (ImageView) findViewById(R.id.imageView17);
        imageView18 = (ImageView) findViewById(R.id.imageView18);
        imageView19 = (ImageView) findViewById(R.id.imageView19);

        MediaPlayer cow = MediaPlayer.create(MainActivity7.this, R.raw.cow);
        cow.start();


        new CountDownTimer(20000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity7.this);
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
                        Toast.makeText(MainActivity7.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity7.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView16.setVisibility(View.INVISIBLE);
                imageView17.setVisibility(View.INVISIBLE);
                imageView18.setVisibility(View.INVISIBLE);
                imageView19.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity7.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity7.this, MainActivity8.class);
                startActivity(intent);
            }
        },3000);
    }
}