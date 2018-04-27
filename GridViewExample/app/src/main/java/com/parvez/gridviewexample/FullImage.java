package com.parvez.gridviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        Intent i=getIntent();

        int position=i.getExtras().getInt("id");
        ImageAdepter imageAdepter=new ImageAdepter(this);

        ImageView imageView=(ImageView)findViewById(R.id.full_image);
        imageView.setImageResource(imageAdepter.mThumbIds[position]);

    }
}
