package com.parvez.listviewwithimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView simpleListView;
    String countryList[]= {"Bangladesh","England","pak"};
    int flag[]={R.drawable.th,android.R.mipmap.sym_def_app_icon,android.R.mipmap.sym_def_app_icon};
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleListView=(ListView)findViewById(R.id.simpleListView);
        CustomAdapter customadepter= new CustomAdapter(getApplicationContext(), countryList, flag);
        simpleListView.setAdapter(customadepter);

    }
}
