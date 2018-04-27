package com.parvez.menuapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView2;
String contacts[]={"parvez","abc","bbc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        listView2=(ListView) findViewById(R.id.listViewxml);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView2.setAdapter(adapter);
       registerForContextMenu(listView2);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("Select The action");
        menu.add(0, Menu.FIRST,Menu.NONE,"call");
        menu.add(0,Menu.FIRST,Menu.NONE,"SMS");
        menu.add(0,Menu.FIRST,Menu.NONE,"News");

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="call"){
            Toast.makeText(getApplicationContext(), "calling codes", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,callActivity.class);
            startActivity(intent);

        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(), "sending sms codes", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,smsActivity.class);
            startActivity(intent);
        }
        else if(item.getTitle()=="News"){
            Toast.makeText(getApplicationContext(), "sending News codes", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,newsActivity.class);
            startActivity(intent);
        }
        else{
            return false;
        }
        return true;
    }

}
