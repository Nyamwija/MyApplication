package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2 extends AppCompatActivity {
    MediaPlayer mPlayer;

    Button buttonPLAY;

    Button buttonCLOSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonPLAY = (Button)findViewById(R.id.button1);

        buttonPLAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.adoration);//Create MediaPlayer object with MP3 file under res/raw folder
                mPlayer.start();//Start playing the music
            }

        });
        buttonCLOSE = (Button) findViewById(R.id.button2);
        buttonCLOSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer != null && mPlayer.isPlaying()) {//If music is playing already
                    mPlayer.stop();//Stop playing the music

                }
            }
        });

    }}



