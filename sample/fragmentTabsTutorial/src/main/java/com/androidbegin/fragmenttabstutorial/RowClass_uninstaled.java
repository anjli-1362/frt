package com.androidbegin.fragmenttabstutorial;

import android.graphics.drawable.Drawable;

/**
 * Created by dell on 5/30/2015.
 */
public class RowClass_uninstaled {

    String date;

    RowClass_uninstaled(String appName, String date){

        this.appName=appName;
        this.date=date;
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
