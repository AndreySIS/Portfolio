package com.example.runrun;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TrainConstructorActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public static final String APP_PREFERENCES_TRAIN = "train";
    public static final String APP_PREFERENCES_DATE = "date";
    public SharedPreferences mSettings;

    private EditText ET_time;
    private EditText ET_date;
    private Spinner S_plan;
    private Spinner S_day;
    private TextView TV_best_result;

    Calendar myCalendar = Calendar.getInstance();

    public static int key;
    public String title_train;
    public String setdate;
    public String getTime;
    public Date setTime;
    public Date middle_speed_time;
    public Date pro_speed_time;
    public Date middle_endurance_time;
    public Date pro_endurance_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_constructor);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ET_time = (EditText) findViewById(R.id.best_result_time);
        ET_date = (EditText) findViewById(R.id.date_start_text);
        TV_best_result = (TextView) findViewById(R.id.best_result_txt);
        S_plan = (Spinner) findViewById(R.id.plan_spinner);
        S_day = (Spinner) findViewById(R.id.day_spinner);

        S_plan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] choose = getResources().getStringArray(R.array.plans_train);
                if (choose[position].equals("Скорость")){
                    TV_best_result.setText("Лучший результат на 100м");
                } else {
                    TV_best_result.setText("Лучший результат на 1000м");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
                String myFormat = "dd.MM.yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                ET_date.setText(sdf.format(myCalendar.getTime()));
            }
        };

        ET_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(TrainConstructorActivity.this, date, myCalendar
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
                mTimePicker = new TimePickerDialog(TrainConstructorActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedMinute, int selectedSecond) {
                        ET_time.setText( selectedMinute + ":" + selectedSecond);
                    }
                }, minute, second, true);
                mTimePicker.show();

            }
        });


    }



    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, key);
        editor.putString(APP_PREFERENCES_TRAIN, title_train);
        editor.putString(APP_PREFERENCES_DATE, setdate);
        editor.apply();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)){
            key = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
            title_train = mSettings.getString(APP_PREFERENCES_TRAIN,"");
            setdate = mSettings.getString(APP_PREFERENCES_DATE,"");
        }
    }


    public void onClick(View view) throws ParseException {
        if (!TextUtils.isEmpty(ET_time.getText().toString()) && !TextUtils.isEmpty(ET_date.getText().toString())) {
            key = 1;
            setdate = ET_date.getText().toString();
            String selectedPlan = S_plan.getSelectedItem().toString();
            String selectedDay = S_day.getSelectedItem().toString();
            getTime();
            if (selectedPlan.equals("Скорость")) {
                if (selectedDay.equals("2-3")) {
                    if (setTime.after(middle_speed_time)) {
                        title_train = "start_speed23";
                    } else if (setTime.after(pro_speed_time) || setTime.compareTo(middle_speed_time) == 0) {
                        title_train = "middle_speed23";
                    } else if (setTime.before(pro_speed_time) || setTime.compareTo(pro_speed_time) == 0) {
                        title_train = "pro_speed23";
                    }
                } else if (selectedDay.equals("3-4")){
                    if (setTime.after(middle_speed_time)) {
                        title_train = "start_speed34";
                    } else if (setTime.after(pro_speed_time) || setTime.compareTo(middle_speed_time) == 0) {
                        title_train = "middle_speed34";
                    } else if (setTime.before(pro_speed_time) || setTime.compareTo(pro_speed_time) == 0) {
                        title_train = "pro_speed34";
                    }
                } else if (selectedDay.equals("4-5")) {
                    if (setTime.after(middle_speed_time)) {
                        title_train = "start_speed45";
                    } else if (setTime.after(pro_speed_time) || setTime.compareTo(middle_speed_time) == 0) {
                        title_train = "middle_speed45";
                    } else if (setTime.before(pro_speed_time) || setTime.compareTo(pro_speed_time) == 0) {
                        title_train = "pro_speed45";
                    }
                }
            } else if (selectedPlan.equals("Выносливость")) {
                if (selectedDay.equals("2-3")) {
                    if (setTime.after(middle_endurance_time)) {
                        title_train = "start_endurance23";
                    } else if (setTime.after(pro_endurance_time) || setTime.compareTo(middle_endurance_time) == 0) {
                        title_train = "middle_endurance23";
                    } else if (setTime.before(pro_endurance_time) || setTime.compareTo(pro_endurance_time) == 0) {
                        title_train = "pro_endurance23";
                    }
                } else if (selectedDay.equals("3-4")){
                    if (setTime.after(middle_endurance_time)) {
                        title_train = "start_endurance34";
                    } else if (setTime.after(pro_endurance_time) || setTime.compareTo(middle_endurance_time) == 0) {
                        title_train = "middle_endurance34";
                    } else if (setTime.before(pro_endurance_time) || setTime.compareTo(pro_endurance_time) == 0) {
                        title_train = "pro_endurance34";
                    }
                } else if (selectedDay.equals("4-5")){
                    if (setTime.after(middle_endurance_time)) {
                        title_train = "start_endurance45";
                    } else if (setTime.after(pro_endurance_time) || setTime.compareTo(middle_endurance_time) == 0) {
                        title_train = "middle_endurance45";
                    } else if (setTime.before(pro_endurance_time) || setTime.compareTo(pro_endurance_time) == 0) {
                        title_train = "pro_endurance45";
                    }
                }
            }
            onPause();
            super.finish();
        } else
            Toast.makeText(TrainConstructorActivity.this, "Заполните все строки", Toast.LENGTH_SHORT).show();
    }

    public void getTime() throws ParseException {

        getTime = ET_time.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        setTime = sdf.parse(getTime);

        middle_speed_time = sdf.parse("15:2");
        pro_speed_time = sdf.parse("12:7");

        middle_endurance_time = sdf.parse("4:0");
        pro_endurance_time = sdf.parse("3:0");

    }


}
