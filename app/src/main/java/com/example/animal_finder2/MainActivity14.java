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

public class MainActivity14 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int score;
    ImageView imageView49;
    ImageView imageView50;
    ImageView imageView51;
    ImageView imageView52;
    ImageView imageView53;
    ImageView imageView54;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        score=13;
        imageView49 = (ImageView) findViewById(R.id.imageView49);
        imageView50 = (ImageView) findViewById(R.id.imageView50);
        imageView51 = (ImageView) findViewById(R.id.imageView51);
        imageView52 = (ImageView) findViewById(R.id.imageView52);
        imageView53 = (ImageView) findViewById(R.id.imageView53);
        imageView54 = (ImageView) findViewById(R.id.imageView54);

        MediaPlayer grosshopper = MediaPlayer.create(MainActivity14.this, R.raw.grosshopper);
        grosshopper.start();


        new CountDownTimer(16000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time Off");
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity14.this);
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
                        Toast.makeText(MainActivity14.this, "Game Over", Toast.LENGTH_SHORT).show();
                        imageView49.setVisibility(View.INVISIBLE);
                        imageView50.setVisibility(View.INVISIBLE);
                        imageView51.setVisibility(View.INVISIBLE);
                        imageView52.setVisibility(View.INVISIBLE);
                        imageView53.setVisibility(View.INVISIBLE);
                        imageView54.setVisibility(View.INVISIBLE);
                    }
                });
                alert.show();
            }
        }.start();

    }

    public void wrongAnswer(View view) {
        MediaPlayer noo = MediaPlayer.create(MainActivity14.this, R.raw.noo);
        noo.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView49.setVisibility(View.INVISIBLE);
                imageView50.setVisibility(View.INVISIBLE);
                imageView51.setVisibility(View.INVISIBLE);
                imageView52.setVisibility(View.INVISIBLE);
                imageView53.setVisibility(View.INVISIBLE);
                imageView54.setVisibility(View.INVISIBLE);

            }
        },6000);
    }

    public void increaseScore(View view) {
        MediaPlayer yougotit = MediaPlayer.create(MainActivity14.this, R.raw.yougotit);
        yougotit.start();

        score++;
        textView2.setText("Score: " +score);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity14.this, MainActivity15.class);
                startActivity(intent);
            }
        },3000);
    }
}