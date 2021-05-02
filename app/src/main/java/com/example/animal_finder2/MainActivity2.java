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

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView3;
    ImageView imageView4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=1;
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);

        MediaPlayer leon = MediaPlayer.create(MainActivity2.this, R.raw.leon);
        leon.start();


        new CountDownTimer(25000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
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
                        Toast.makeText(MainActivity2.this, "Game Over", Toast.LENGTH_SHORT).show();
                        imageView3.setVisibility(View.INVISIBLE);
                        imageView4.setVisibility(View.INVISIBLE);
                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity2.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView3.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.INVISIBLE);
            }
        },5000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity2.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        },3000);
    }
}