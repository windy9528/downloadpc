package com.yanggaofeng20190713.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
