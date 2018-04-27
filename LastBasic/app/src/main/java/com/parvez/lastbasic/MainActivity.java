package com.parvez.lastbasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText n;
TextView dt,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=(EditText)findViewById((R.id.name));
        dt=(TextView)findViewById((R.id.display));
        res=(TextView)findViewById((R.id.abc));

    }
    public void show(View view) {
        dt.setText(n.getText().toString());
        res.setText("Name"+n.getText().toString());
    }

}