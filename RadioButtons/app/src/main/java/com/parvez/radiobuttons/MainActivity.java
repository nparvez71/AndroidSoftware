package com.parvez.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        radioGroup=(RadioGroup)findViewById(R.id.radio);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                int selectedId =radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this,radioButton.getText(), Toast.LENGTH_SHORT).show();
                                          }
                                      }


        );
    }
}
