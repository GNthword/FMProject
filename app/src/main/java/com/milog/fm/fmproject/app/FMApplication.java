package com.milog.fm.fmproject.app;

import android.app.Application;

/**
 * Created by miloway on 2018/10/18.
 */

public class FMApplication extends Application {

    private static FMApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static FMApplication getApplication() {
        return application;
    }
}
