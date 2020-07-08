package com.example.runrun;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChooseTrainActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public static final String APP_PREFERENCES_TRAIN = "train";
    public static final String APP_PREFERENCES_DATE = "date";
    public SharedPreferences mSettings;


    public TextView textView;
    public ImageView IVtitle;

    public static int key;
    public String title_train;
    public String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_train);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        textView = (TextView) findViewById(R.id.text_info);
        IVtitle = (ImageView) findViewById(R.id.title_ImageView);
        title_train = getIntent().getExtras().getString("title_train");
        if (title_train.equals("start_speed34")) {
            IVtitle.setImageResource(R.drawable.start_speed1);
            textView.setText(R.string.about_start_speed);
        } else if (title_train.equals("start_endurance34")) {
            IVtitle.setImageResource(R.drawable.start_endurance);
            textView.setText(R.string.about_start_endurance);
        } else if (title_train.equals("middle_speed45")) {
            IVtitle.setImageResource(R.drawable.middle_speed);
            textView.setText(R.string.about_middle_speed);
        } else if (title_train.equals("middle_endurance45")) {
            IVtitle.setImageResource(R.drawable.middle_endurance);
            textView.setText(R.string.about_middle_endurance);
        } else if (title_train.equals("pro_speed45")) {
            IVtitle.setImageResource(R.drawable.pro_speed);
            textView.setText(R.string.about_pro_speed);
        } else if (title_train.equals("pro_endurance45")) {
            IVtitle.setImageResource(R.drawable.pro_endurance);
            textView.setText(R.string.about_pro_endurance);
        }

    }

    public void onClick(View view) {
        key = 1;
        title_train = getIntent().getExtras().getString("title_train");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        date = sdf.format(Calendar.getInstance().getTime());
        onPause();
        onResume();
        super.finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, key);
        editor.putString(APP_PREFERENCES_TRAIN, title_train);
        editor.putString(APP_PREFERENCES_DATE, date);
        editor.apply();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)){
            key = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
            title_train = mSettings.getString(APP_PREFERENCES_TRAIN,"");
            date = mSettings.getString(APP_PREFERENCES_DATE,"");
        }
    }

}
