package com.example.runrun;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SaveSettings extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public SharedPreferences mSettings;
    public int key = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        onResume();
        onPause();
    }


    public void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, key);
        editor.apply();
    }


    public void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)){
            key = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
        }
        //textView.setText(Integer.toString(key));
    }
}
