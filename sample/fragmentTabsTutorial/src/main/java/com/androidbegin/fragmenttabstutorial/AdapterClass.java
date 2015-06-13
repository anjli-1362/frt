package com.androidbegin.fragmenttabstutorial;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 5/29/2015.
 */
public class AdapterClass extends BaseAdapter {


    ArrayList<RowClass> rowClass;
    Context context;

    PackageManager pm ;
    List<ApplicationInfo> packages;

    ImageView iv1,iv2,iv3;
    TextView tv1,tv2,tv3;
    LayoutInflater inflater;


    AdapterClass( List<ApplicationInfo> packages, Context context){

        this.packages=packages;
        this.context=context;
        this.inflater = LayoutInflater.from(context);

}



    @Override
    public int getCount() {
        int c= (int) Math.ceil(packages.size() / 3);


        return c;
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

        convertView=inflater.inflate(R.layout.row_instaled, parent, false);



        int count=packages.size();
        int i=position*3;

        pm = context.getPackageManager();


            if(i<count||i<=((position*3)+2)) {

                ApplicationInfo packageInfo=packages.get(i);
                PackageInfo packInfo =null;

                try {
                    packInfo = pm.getPackageInfo(packageInfo.packageName, PackageManager.GET_PERMISSIONS);
                }
                catch (Exception e)
                {
                    //Log.d(TAG,"error in info");
                }

                iv1 = (ImageView) convertView.findViewById(R.id.iv_instaled1);
                iv1.setImageDrawable(pm.getApplicationIcon(packInfo.applicationInfo));

                tv1=(TextView)  convertView.findViewById(R.id.tv1);
                tv1.setText(packageInfo.loadLabel(pm).toString());

                System.out.println("123: ");

                i=i+1;

            }



        if(i<count||i<=((position*3)+2)) {

      ApplicationInfo packageInfo=packages.get(i);
            PackageInfo packInfo =null;

            try {
                packInfo = pm.getPackageInfo(packageInfo.packageName, PackageManager.GET_PERMISSIONS);
            }
            catch (Exception e)
            {
                //Log.d(TAG,"error in info");
            }

            iv2 = (ImageView) convertView.findViewById(R.id.iv_instaled2);
            iv2.setImageDrawable(pm.getApplicationIcon(packInfo.applicationInfo));

            tv2=(TextView)  convertView.findViewById(R.id.tv2);
            tv2.setText(packageInfo.loadLabel(pm).toString());

            System.out.println("123: ");

            i=i+1;
            //add(packageInfo.loadLabel(pm).toString(),packInfo.lastUpdateTime);
        }

        if(i<count||i<=((position*3)+2)) {



            ApplicationInfo packageInfo=packages.get(i);
            PackageInfo packInfo =null;

            try {
                packInfo = pm.getPackageInfo(packageInfo.packageName, PackageManager.GET_PERMISSIONS);
            }
            catch (Exception e)
            {
                //Log.d(TAG,"error in info");
            }

            iv3 = (ImageView) convertView.findViewById(R.id.iv_instaled3);
            iv3.setImageDrawable(pm.getApplicationIcon(packInfo.applicationInfo));

            tv3=(TextView)  convertView.findViewById(R.id.tv3);
            tv3.setText(packageInfo.loadLabel(pm).toString());

            System.out.println("123: ");



            i=i+1;
            //add(packageInfo.loadLabel(pm).toString(),packInfo.lastUpdateTime);
        }



        return convertView;
    }
    public void add(String a, double b)
    {
        MainActivity.samg.put(a,b);
    }

}
