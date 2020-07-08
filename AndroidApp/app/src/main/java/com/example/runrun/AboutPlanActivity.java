package com.example.runrun;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutPlanActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public static final String APP_PREFERENCES_TRAIN = "train";
    public SharedPreferences mSettings;

    public int key;
    public String title_train;

    public TextView textView;
    public ImageView IVtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_plan);

        textView = (TextView) findViewById(R.id.text_info);
        IVtitle = (ImageView) findViewById(R.id.title_ImageView);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        onResume();
        if (title_train.equals("start_speed23") || title_train.equals("start_speed34") || title_train.equals("start_speed45")) {
            IVtitle.setImageResource(R.drawable.start_speed1);
            textView.setText(R.string.about_start_speed);
        } else if (title_train.equals("start_endurance23") || title_train.equals("start_endurance34") || title_train.equals("start_endurance45")) {
            IVtitle.setImageResource(R.drawable.start_endurance);
            textView.setText(R.string.about_start_endurance);
        } else if (title_train.equals("middle_speed23") || title_train.equals("middle_speed34") || title_train.equals("middle_speed45")) {
            IVtitle.setImageResource(R.drawable.middle_speed);
            textView.setText(R.string.about_middle_speed);
        } else if (title_train.equals("middle_endurance23") || title_train.equals("middle_endurance34") || title_train.equals("middle_endurance45")) {
            IVtitle.setImageResource(R.drawable.middle_endurance);
            textView.setText(R.string.about_middle_endurance);
        } else if (title_train.equals("pro_speed23") || title_train.equals("pro_speed34") || title_train.equals("pro_speed45")) {
            IVtitle.setImageResource(R.drawable.pro_speed);
            textView.setText(R.string.about_pro_speed);
        } else if (title_train.equals("pro_endurance23") || title_train.equals("pro_endurance34") || title_train.equals("pro_endurance45")) {
            IVtitle.setImageResource(R.drawable.pro_endurance);
            textView.setText(R.string.about_pro_endurance);
        }

    }

    public void onClick(View view) {
        key = 0;
        onPause();
        super.finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, key);
        editor.apply();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)){
            key = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
            title_train = mSettings.getString(APP_PREFERENCES_TRAIN,"");
        }
    }


}
