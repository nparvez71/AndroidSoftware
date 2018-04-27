package com.parvez.datapassingandmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Desplay extends AppCompatActivity {
TextView dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplay);
        dis=(TextView) findViewById(R.id.textp);
        Intent intent=getIntent();
        String n=intent.getStringExtra("pavez");
        dis.setText(n);
    }
}
