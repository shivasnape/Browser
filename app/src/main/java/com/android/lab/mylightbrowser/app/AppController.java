package com.android.lab.mylightbrowser.app;

import android.app.Application;


/**
 * Created by USER on 19/12/17.
 */

public class AppController extends Application {

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

}