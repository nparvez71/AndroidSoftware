package com.parvez.editboxindalogue;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final Context context=this;
    private Button button;
    private EditText result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button);
        result=(EditText) findViewById(R.id.ediText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li=LayoutInflater.from(context);
                View promprtsView= li.inflate(R.layout.prompt,null);
                AlertDialog.Builder alertDaiBuilder=new AlertDialog.Builder(context);
                alertDaiBuilder.setView(promprtsView);
                final EditText userInput=(EditText) promprtsView.findViewById(R.id.textDailog);
                alertDaiBuilder.setCancelable(false).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {

                        result.setText(userInput.getText());


                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                    }
                });

               AlertDialog alertDialog=alertDaiBuilder.create();

                alertDialog.show();
            }
        });
    }
}
