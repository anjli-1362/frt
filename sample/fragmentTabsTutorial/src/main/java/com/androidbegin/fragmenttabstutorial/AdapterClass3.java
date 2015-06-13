package com.androidbegin.fragmenttabstutorial;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 5/30/2015.
 */
public class AdapterClass3 extends BaseAdapter {



    Context context;

    PackageManager pm ;
    List<RowClass_update> rowClass;

    ImageView iv1;
    TextView name, date, count;
    LayoutInflater inflater;


    AdapterClass3( List<RowClass_update> rowClass, Context context){

        this.rowClass=rowClass;
        this.context=context;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {

        return rowClass.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        packages.get(position).

        convertView=inflater.inflate(R.layout.f2_row, parent, false);

        iv1 = (ImageView) convertView.findViewById(R.id.f2_image);

        // set image here
        //  iv1.setImageDrawable();

        name=(TextView)  convertView.findViewById(R.id.f2_appname);
        name.setText(rowClass.get(position).getAppName());

        date=(TextView)  convertView.findViewById(R.id.f2_date);
        date.setText(rowClass.get(position).getDate());

        count=(TextView)  convertView.findViewById(R.id.count);
        count.setText("");
        //count.setText("Updated "+rowClass.get(position).getCount()+" times");

        System.out.println("12345: ");



        return convertView;
    }
}
