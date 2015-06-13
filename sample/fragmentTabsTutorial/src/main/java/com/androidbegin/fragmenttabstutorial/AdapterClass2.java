package com.androidbegin.fragmenttabstutorial;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 5/30/2015.
 */
public class AdapterClass2 extends BaseAdapter {



    Context context;

    PackageManager pm ;
    List<RowClass_uninstaled> rowClass;

    ImageView iv1;
    TextView name, date;
    LayoutInflater inflater;


    AdapterClass2( List<RowClass_uninstaled> rowClass, Context context){

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

        convertView=inflater.inflate(R.layout.f3_row, parent, false);

        iv1 = (ImageView) convertView.findViewById(R.id.image);

          // set image here
          //  iv1.setImageDrawable();

            name=(TextView)  convertView.findViewById(R.id.f3_app_name);
            name.setText(rowClass.get(position).getAppName());

        date=(TextView)  convertView.findViewById(R.id.f3_date);
        date.setText(rowClass.get(position).getDate());

            System.out.println("1232: ");



        return convertView;
    }
}
