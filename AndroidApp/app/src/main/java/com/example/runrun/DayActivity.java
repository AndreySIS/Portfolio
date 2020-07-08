package com.example.runrun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        ListView listView = (ListView)findViewById(R.id.listView1);
        String[] day = getResources().getStringArray(R.array.days);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, day);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Intent intent = new Intent(DayActivity.this, TrainActivity.class);;
                String strText = textView.getText().toString();
                String[] train;
                String title_train=getIntent().getExtras().getString("title_train");
                String week = getIntent().getExtras().getString("week");
                String day;
                if (strText.equalsIgnoreCase("День 1")) {
                    day = "day1";
                    SetTrain.setTrain(intent,title_train,week,day);
                } else if (strText.equalsIgnoreCase("День 2")) {
                    day = "day2";
                    SetTrain.setTrain(intent,title_train,week,day);
                } else if (strText.equalsIgnoreCase("День 3")) {
                    day = "day3";
                    SetTrain.setTrain(intent,title_train,week,day);
                } else if (strText.equalsIgnoreCase("День 4")) {
                    day = "day4";
                    SetTrain.setTrain(intent,title_train,week,day);
                } else if (strText.equalsIgnoreCase("День 5")) {
                    day = "day5";
                    SetTrain.setTrain(intent,title_train,week,day);
                } else if (strText.equalsIgnoreCase("День 6")) {
                    day = "day6";
                    SetTrain.setTrain(intent,title_train,week,day);
                } else if (strText.equalsIgnoreCase("День 7")) {
                    day = "day7";
                    SetTrain.setTrain(intent,title_train,week,day);
                }
                startActivity(intent);
            }
        });
    }
}
