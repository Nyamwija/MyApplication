package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
  private Button startService;
//button objects
private Button buttonStart;
    private Button buttonStop;
    public static String nam1 = "main1.java";
    public static String nam = "main2.java";


    private Battery receive= new Battery(){
        @Override
        public void onReceive(Context context, Intent intent) {
            int r=intent.getIntExtra("level",0);
            ProgressBar bar=findViewById(R.id.progressBar);
            bar.setProgress(r);
            TextView battery =findViewById(R.id.level);
            battery.setText(String.format("Battery level:%s%%", Integer.toString(r)));

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService=(Button) findViewById(R.id.service) ;
        startService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ringtone.class);
                startActivity(intent);
            }
        });



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


    public void OnClick(View view){

        EditText editText=findViewById(R.id.alar);
        int b=Integer.parseInt(editText.getText().toString());
        Intent intent=new Intent(getApplicationContext(),MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(b*1000),pendingIntent);
        Toast.makeText(this,"alarm set in"+ b +"seconds",Toast.LENGTH_LONG).show();


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

            case R.id.nam4:
                startActivity(new Intent(this, Storage.class));
                return true;
            //creating email
            // case R.id.email:
            // startActvity(new intent(this helo.xml. class));intent2 = new Intent(Intent.ACTION_SEND);
            //intent2.setData(Uri.parse("mailto:"));
            // String to []={"pearlnyamwija@gmail.com","bryntu9@gmail.com",
            //"asasiiraannabel@gmail.com");
            //intent2.putExtra(Intent.EXTRA_EMAIL,to);
            // intent2.putExtra(Intent.EXTRA_SUBJECT, nam "assignment");
            // intent2.putExtra(Intent.EXTRA_TEXT,  nam "u are reminded to send the assignment in the aftrn thank u");
            // intent2.setType("message/rfc822");
            // startActvity(intent2);
            default:

            return super.onOptionsItemSelected(item);
        }

    }

}



