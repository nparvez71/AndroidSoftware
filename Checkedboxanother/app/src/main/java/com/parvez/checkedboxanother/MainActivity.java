package com.parvez.checkedboxanother;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    CheckBox reading, writing, speaking;
    Button button, button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reading = findViewById(R.id.readingId);
        writing = findViewById(R.id.writingId);
        speaking = findViewById(R.id.speakingId);
        button = findViewById(R.id.buttonId);
        button2 = findViewById(R.id.buttonId2);
        textView = findViewById(R.id.resultId);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();

                if(reading.isChecked()){
                    String value = reading.getText().toString();
                    stringBuilder.append("Your hobby is " + value + "\n");
                }if(writing.isChecked()){
                    String value = writing.getText().toString();
                    stringBuilder.append("Your hobby is " + value + "\n");
                }if(speaking.isChecked()){
                    String value = speaking.getText().toString();
                    stringBuilder.append("Your hobby is " + value + "\n");
                }
                textView.setText(stringBuilder);
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });
    }
}
