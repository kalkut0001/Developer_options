package com.arijit.devoptins.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arijit.devoptins.R;

import java.util.prefs.Preferences;


/**
 * Android login screen Activity
 */
public class MainActivity extends Activity {

    private Context mCtx;
    Button thBtn;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCtx = this;

        thBtn=findViewById(R.id.the_button);
        // create the get Intent object
        Intent intent = getIntent();
        // receive the value by getStringExtra() method and

        thBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
                startActivityForResult(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS), SECOND_ACTIVITY_REQUEST_CODE );

            }
        });

    }


}