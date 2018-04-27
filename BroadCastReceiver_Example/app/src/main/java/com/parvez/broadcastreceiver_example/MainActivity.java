package com.parvez.broadcastreceiver_example;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,cancel;
CheckBox chkk;
AudioManager myAudioManager;
PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlerts();
            }


        });
        cancel=(Button)findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                cancelAlerts();
            }
        });
        chkk=(CheckBox) findViewById(R.id.check_box);
        chkk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startAlerts();
                }else{
                    cancelAlerts();

                }

            }
        });
    }


    private void cancelAlerts() {
    }

    private void startAlerts() {
        EditText text=(EditText) findViewById(R.id.time);
        int  i=Integer.parseInt(text.getText().toString());
        Intent intent=new Intent(this,MyBroadcastReceiver.class);

        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),234324243,intent,pendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP,(i*1000),(50*1000),pendingIntent);
        Toast.makeText(this, "Alarm set in"+ i +"seconds", Toast.LENGTH_SHORT).show();

    }
}
