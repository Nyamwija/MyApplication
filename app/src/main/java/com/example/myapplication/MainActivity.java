package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String nam1 = "main1.java";
    public static String nam = "main2.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {

        EditText message = (EditText) findViewById(R.id.textView);
        Toast.makeText(this, "Sending message" + message.getText().toString(),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);

        message.setText("");

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf =
                getMenuInflater();
        inf.inflate(R.menu.helo, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId1 = item.getItemId();
        switch (itemId1) {
            case R.id.nam1:
                Intent i = new Intent(this, main1.class);
                // Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse(nam1));

            case R.id.nam:
                startActivity(new Intent(this, Main2.class));
                return true;
            case R.id.list:
                startActivity(new Intent(this, ListView.class));
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}


