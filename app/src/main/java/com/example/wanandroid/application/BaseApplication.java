package com.example.wanandroid.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

public class BaseApplication extends Application {

    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        // 屏幕适配
        ScreenAdapterTools.init(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ScreenAdapterTools.getInstance().reset(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
