package com.androidbegin.fragmenttabstutorial;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FragmentTab1 extends Fragment implements AdapterView.OnItemClickListener {

    ListView f1lv;
    AdapterClass adapter;
    ArrayList<RowClass> rowClass=new ArrayList<RowClass>() ;
    int flag=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab1, container, false);
        return rootView;
    }


    PackageManager pm;
    List<ApplicationInfo> packages ;

    @Override
    public void onStart() {
        super.onStart();


    pm = getActivity().getPackageManager();

    packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

    f1lv = (ListView) getView().findViewById(R.id.f1_lv);
    prepData();
    f1lv.setOnItemClickListener(this);
    adapter = new AdapterClass(packages, getActivity());
    f1lv.setAdapter(adapter);

flag=1;


    }


    public void prepData(){
        pm = getActivity().getPackageManager();


        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            //Log.d(TAG, "Installed package :" + packageInfo.loadLabel(pm));
            //Log.d(TAG, "Installed package :" + packageInfo.packageName);
            PackageInfo packInfo = null;
            try {
                packInfo = pm.getPackageInfo(packageInfo.packageName, PackageManager.GET_PERMISSIONS);
            } catch (Exception e) {
                //Log.d(TAG,"error in info");
            }
            MainActivity.samg.put(packageInfo.loadLabel(pm).toString(), packInfo.lastUpdateTime);
        }



    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}