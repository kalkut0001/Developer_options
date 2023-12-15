package com.arijit.devoptins;


import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;


/**
 *
 */
public class MyApp extends MultiDexApplication {

    private static MyApp mainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }


    public static synchronized MyApp getInstance() {
        return mainApplication;
    }
}
