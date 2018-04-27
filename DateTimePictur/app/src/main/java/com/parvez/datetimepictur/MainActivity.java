package com.parvez.datetimepictur;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText st;
TimePickerDialog mTimePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        st=(EditText)findViewById(R.id.stime);
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrevtTime=Calendar.getInstance();
                int hour=mcurrevtTime.get(Calendar.HOUR_OF_DAY);
                int minute=mcurrevtTime.get(Calendar.MINUTE);
                mTimePicker =new TimePickerDialog(MainActivity.this,new TimePickerDialog.OnTimeSetListener() {


                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectesHour, int selectedMinute) {
                        st.setText(selectesHour + "::" + selectedMinute);
                    }
                },hour,minute,true);

                mTimePicker.setTitle("select End Time");
                mTimePicker.show();

            }
        });
    }
}
