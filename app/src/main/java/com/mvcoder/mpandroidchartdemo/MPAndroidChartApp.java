package com.mvcoder.mpandroidchartdemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class MPAndroidChartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
