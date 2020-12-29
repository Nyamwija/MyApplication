package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ringtone extends AppCompatActivity implements View.OnClickListener {

    //button objects
    private Button buttonStart;
    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtone);

        //getting buttons from xml
        buttonStart = (Button) findViewById(R.id.start);
        buttonStop = (Button) findViewById(R.id.stop);

        //attaching onclicklistener to buttons
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonStart) {
            //start the service here
            startService(new Intent(this, MyService.class));
        } else if (view == buttonStop) {
            //stop the service here
            stopService(new Intent(this, MyService.class));
        }
    }

    }

