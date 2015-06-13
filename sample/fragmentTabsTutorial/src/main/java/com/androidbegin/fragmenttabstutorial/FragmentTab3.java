package com.androidbegin.fragmenttabstutorial;

import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentTab3 extends Fragment implements AdapterView.OnItemClickListener{



int flag=0;
    ListView f3lv;
    AdapterClass3 adapter;
    ArrayList<RowClass_update> rowClass=new ArrayList<RowClass_update>() ;
/*
    PackageManager pm;
    List<ApplicationInfo> packages ;*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab3, container, false);
        return rootView;
    }



    public void onStart() {
        super.onStart();


    f3lv = (ListView) getView().findViewById(R.id.f3_lv);

    f3lv.setOnItemClickListener(this);
    prepData();   //add data here from data base to class  also change the class to add the image aswell
    adapter = new AdapterClass3(rowClass, getActivity());
    System.out.println("1234: " + rowClass.size());
    f3lv.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    flag=1;



    }


    public void prepData(){
        Log.d("Up check", "Updated Applications: ");
        for (int i=0; i<MainActivity.samg.size();i++)
        {
            String key=MainActivity.samg.keyAt(i).toString();
            if (MainActivity.samr.containsKey(key)==true)
            {
                long ov=Long.parseLong(MainActivity.samr.get(key).toString());
                long nv=Long.parseLong(MainActivity.samg.get(key).toString());
                if (nv>ov)

                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String dateString = formatter.format(new Date(nv));
                    rowClass.add(new RowClass_update(key,"1",dateString));

                    MainActivity.samr.remove(key);
                    //MainActivity.samr.add(key);

                    //listItems.add(key);
                    //adapter.notifyDataSetChanged();
                }
            }
        }

        // this is sample data
        /*rowClass.add(new RowClass_update("App1","2","21/2/2015"));
        rowClass.add(new RowClass_update("App1","3","15/3/2015"));
        rowClass.add(new RowClass_update("App1","1","12/4/2015"));
        rowClass.add(new RowClass_update("App1","2","13/5/2015"));*/


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}