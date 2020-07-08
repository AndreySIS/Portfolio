package com.example.runrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TrainActivity extends AppCompatActivity {

    private Button btn_add_result;

    private DatabaseReference myRef;

    FirebaseListAdapter mAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        myRef = FirebaseDatabase.getInstance().getReference();

        listView = (ListView) findViewById(R.id.listView1);
        String title_train = getIntent().getExtras().getString("title_train");
        String week = getIntent().getExtras().getString("week");
        String day = getIntent().getExtras().getString("day");

        btn_add_result = (Button) findViewById(R.id.add_resul_btn);
        btn_add_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrainActivity.this, AddTrainActivity.class);
                startActivity(intent);

            }
        });

        mAdapter = new FirebaseListAdapter<String>(
                this,
                String.class,
                android.R.layout.simple_list_item_1,
                myRef.child("plans").child(title_train).child(week).child(day)
        ) {
            @Override
            protected void populateView(View v, String s, int position) {
                TextView text = (TextView) v.findViewById(android.R.id.text1);
                text.setText(s);
            }
        };
        listView.setAdapter(mAdapter);





    }

}
