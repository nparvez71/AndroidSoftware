package com.parvez.sharedpreference_example;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText message;
SeekBar seekBar;
float fontSize;
String fontColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String test_info;
        message=findViewById(R.id.message);
        seekBar=findViewById(R.id.seek_bar);
        SharedPreferences sharedPreferences= MainActivity.this.getSharedPreferences(
           getString(R.string.PREF_FILE), MODE_PRIVATE );
        test_info =sharedPreferences.getString(getString(R.string.TEXT_INFO), "");
        message.setText(test_info);
        fontSize=sharedPreferences.getFloat(getString(R.string.FONT_SIZE), 30);
        fontColor=sharedPreferences.getString(getString(R.string.FONT_COLOR), "");
        message.setTextSize(TypedValue.COMPLEX_UNIT_PX,fontSize);
       if(fontSize == 30){
         seekBar.setProgress(0);
       }else{
           seekBar.setProgress((int) fontSize);
       }
       if(fontColor.equals("RED")){
           message.setTextColor(Color.parseColor("#FF0000"));
       }else if(fontColor.equals("GREEN")){
           message.setTextColor(Color.parseColor("#00FF00"));

       } else{
           message.setTextColor(Color.parseColor("#0000FF"));
       }

       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               message.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               fontSize =message.getTextSize();
           }
       });
    }

       public void changecolor(View v){
           switch (v.getId()){
               case R.id.red:
                   message.setTextColor(Color.parseColor("#FF0000"));
                   fontColor ="REd";
                   break;
               case R.id.green:
                   message.setTextColor(Color.parseColor("#00FF00"));
                   fontColor ="Green";
                   break;
               case R.id.blue:
                   message.setTextColor(Color.parseColor("#0000FF"));
                   fontColor ="Blue";
                   break;
           }
    }


    public void Save(View view){
        SharedPreferences sharedPreferences= MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE );

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putFloat(getString(R.string.FONT_SIZE), fontSize);
        editor.putString(getString(R.string.FONT_COLOR), fontColor);
        editor.putString(getString(R.string.TEXT_INFO), message.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

    }

    public void Clear(View view){
        SharedPreferences sharedPreferences= MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE );

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
    }

    }

