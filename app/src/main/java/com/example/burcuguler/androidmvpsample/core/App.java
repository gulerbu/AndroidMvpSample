package com.example.burcuguler.androidmvpsample.core;

import android.app.Application;

/**
 * Created by burcuguler on 4.02.2018.
 */

public class App extends Application {

    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
