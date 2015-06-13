package com.androidbegin.fragmenttabstutorial;

/**
 * Created by dell on 5/30/2015.
 */
public class RowClass_update{

    String date;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    String count;
    RowClass_update(String appName,String count, String date){

        this.appName=appName;
        this.date=date;
        this.count=count;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String appName;
    String image;

}

