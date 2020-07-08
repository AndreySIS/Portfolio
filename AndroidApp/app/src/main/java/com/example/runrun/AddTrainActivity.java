package com.example.runrun;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddTrainActivity extends AppCompatActivity {

    private EditText ET_dist;
    private EditText ET_time;
    private EditText ET_date;

    private Button Btn_new_train;

    Calendar myCalendar = Calendar.getInstance();

    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;

    private DatabaseReference mDatabaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_train);


        mAuth = FirebaseAuth.getInstance();

        mCurrentUser = mAuth.getCurrentUser();

        ET_dist = (EditText) findViewById(R.id.dist_editText);
        ET_time = (EditText) findViewById(R.id.time_editText);
        ET_date = (EditText) findViewById(R.id.date_editText);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Train").child(mCurrentUser.getUid());

        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());

        Btn_new_train = (Button) findViewById(R.id.add_button);
        Btn_new_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(ET_dist.getText().toString()) && !TextUtils.isEmpty(ET_time.getText().toString()) && !TextUtils.isEmpty(ET_date.getText().toString())) {
                    final String dist_val = ET_dist.getText().toString().trim();
                    final String time_val = ET_time.getText().toString().trim();
                    final String date_val = ET_date.getText().toString().trim();
                    final DatabaseReference newTrain = mDatabase.push();

                    mDatabaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            newTrain.child("dist").setValue(dist_val);
                            newTrain.child("time").setValue(time_val);
                            newTrain.child("date").setValue(date_val);
                            newTrain.child("uid").setValue(mCurrentUser.getUid());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(AddTrainActivity.this, "Пробежка добавлена", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AddTrainActivity.this, "Заполните все строки", Toast.LENGTH_SHORT).show();
            }
        });


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "dd.MM.yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                ET_date.setText(sdf.format(myCalendar.getTime()));
            }
        };

        ET_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddTrainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ET_time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int minute = 00;
                int second = 00;

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddTrainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedMinute, int selectedSecond) {
                        ET_time.setText( selectedMinute + ":" + selectedSecond);
                    }
                }, minute, second, true);
                mTimePicker.show();

            }
        });




    }




}
