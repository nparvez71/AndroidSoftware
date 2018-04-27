package com.parvez.checkboxdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox Bangladesh,India,Pakistan;
Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtononClick();
    }

    private void addListenerOnButtononClick() {
        Bangladesh=(CheckBox)findViewById(R.id.checkBox);
        India=(CheckBox)findViewById(R.id.checkBox1);
        Pakistan=(CheckBox)findViewById(R.id.checkBox2);
        buttonOrder=(Button)findViewById(R.id.button);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder result=new StringBuilder();
                result.append("selected Iteam:");
                if(Bangladesh.isChecked()){
                    result.append("\nBangladesh 15 correr people");
                    totalamount+=1500000000;
                }
                if(India.isChecked()){
                    result.append("\nIndia 115 correr people");
                    totalamount+=1150000000;
                }

                if(Pakistan.isChecked()){
                    result.append("\nPakistan 25 correr people");
                    totalamount+=250000000;
                }
                    result.append("\nTotal:"+totalamount+"Correr");
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
