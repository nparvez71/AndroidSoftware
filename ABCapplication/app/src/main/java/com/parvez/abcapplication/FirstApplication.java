package com.parvez.abcapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstApplication extends AppCompatActivity {
    Button b1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_application);

        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstApplication.this, "Hello Parvez Boss!!", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void details(View v){
        Intent i = new Intent(FirstApplication.this, Details.class);
        startActivity(i);
    }
}
