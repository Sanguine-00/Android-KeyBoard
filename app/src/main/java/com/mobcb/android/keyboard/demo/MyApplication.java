package com.mobcb.android.keyboard.demo;

import android.app.Application;
import android.content.Context;

import com.mobcb.android.keyboard.demo.util.ScreenUtils;
import com.mobcb.android.keyboard.demo.util.Utils;

public class MyApplication extends Application {

    private Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = MyApplication.this;

        /*常用工具类初始化*/
        Utils.init(appContext);
        /*设置屏幕适配比率*/
        initDensity();
    }

    /**
     * 设置屏幕适配比率
     */
    private void initDensity() {
        final float density = ScreenUtils.getScreenWidth() / 375f;
        appContext.getResources().getDisplayMetrics().density = density;
        appContext.getResources().getDisplayMetrics().scaledDensity = density;
    }
}
