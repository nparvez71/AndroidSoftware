package com.parvez.listviewwithimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by J2EE-33 on 3/29/2018.
 */

public class CustomAdapter extends BaseAdapter{
    Context context;
    String countryList[];
    int flag[];
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] countryList, int[] flag) {
        this.context = context;
        this.countryList = countryList;
        this.flag = flag;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return countryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =inflater.inflate(R.layout.listview, null);
        TextView country=(TextView) view.findViewById(R.id.textView);
        ImageView icon=(ImageView) view.findViewById(R.id.icon);
        country.setText(countryList[i]);
        icon.setImageResource(flag[i]);
        return view;
    }
}
