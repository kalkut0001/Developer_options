package com.arijit.devoptins.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Button;
import com.arijit.devoptins.R;
import java.util.prefs.Preferences;


public class Splash extends Activity {

    private Context mCtx;
    Preferences mPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        mCtx = this;

        boolean isDevOn=isDevMode();
        boolean isUsbDebuggingOn=usbDebussingMode();
        Intent intent = new Intent(mCtx, MainActivity.class);
        intent.putExtra("isDevOn", String.valueOf(isDevOn));
        intent.putExtra("isUsbDebuggingOn", String.valueOf(isUsbDebuggingOn));
        startActivity(intent);
        finish();
    }
    @android.annotation.TargetApi(17) public boolean isDevMode() {
        if(Integer.valueOf(android.os.Build.VERSION.SDK_INT) == 16) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED , 0) != 0;
        } else if (Integer.valueOf(Build.VERSION.SDK_INT) >= 17) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                    android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED , 0) != 0;
        } else return false;
    }
    @android.annotation.TargetApi(17) public boolean usbDebussingMode() {
        if(Integer.valueOf(android.os.Build.VERSION.SDK_INT) == 16) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ADB_ENABLED , 0) != 0;
        } else if (Integer.valueOf(Build.VERSION.SDK_INT) >= 17) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                    Settings.Global.ADB_ENABLED , 0) != 0;
        } else return false;
    }





    @Override
    protected void onResume() {
        super.onResume();


    }


    public void onBackPressed() {

        super.onBackPressed();
        finish();

    }



}
