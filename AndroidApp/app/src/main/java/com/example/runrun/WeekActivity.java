package com.example.runrun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WeekActivity extends Activity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_week);

        ListView listView = (ListView)findViewById(R.id.listView1);
        String[] week = getResources().getStringArray(R.array.four_week);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, week);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Intent intent = new Intent(WeekActivity.this, DayActivity.class);
                String strText = textView.getText().toString();
                String title_train = getIntent().getExtras().getString("title_train");
                intent.putExtra("title_train", title_train);
                String week;
                if (strText.equalsIgnoreCase("Неделя 1")) {
                    week = "week1";
                    intent.putExtra("week", week);
                }
                else if (strText.equalsIgnoreCase("Неделя 2")) {
                    week = "week2";
                    intent.putExtra("week", week);
                }
                else if (strText.equalsIgnoreCase("Неделя 3")) {
                    week = "week3";
                    intent.putExtra("week", week);
                }
                else if (strText.equalsIgnoreCase("Неделя 4")) {
                    week = "week4";
                    intent.putExtra("week", week);

                }
                startActivity(intent);
            }
        });
    }

}
