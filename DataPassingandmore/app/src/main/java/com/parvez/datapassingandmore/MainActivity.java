package com.parvez.datapassingandmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n=(EditText)findViewById(R.id.name);

    }


public void gotoDisplay(View view){
        String nn=n.getText().toString();

        if(nn.length() != 0){

            Intent intent=new Intent(this, Desplay.class);
            intent.putExtra("pavez",nn);
            startActivity(intent);
        }
}
}
