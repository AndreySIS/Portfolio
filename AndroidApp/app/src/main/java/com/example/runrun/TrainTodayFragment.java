package com.example.runrun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TrainTodayFragment extends Fragment {

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_TRAIN = "train";
    public static final String APP_PREFERENCES_DATE = "date";
    public SharedPreferences mSettings;

    public String title_train;
    public String[] train;
    public String date;
    public Date today;
    public Date todayWithZeroTime;
    public Calendar instance = Calendar.getInstance();

    public Date week1day1;
    public Date week1day2;
    public Date week1day3;
    public Date week1day4;
    public Date week1day5;
    public Date week1day6;
    public Date week1day7;

    public Date week2day1;
    public Date week2day2;
    public Date week2day3;
    public Date week2day4;
    public Date week2day5;
    public Date week2day6;
    public Date week2day7;

    public Date week3day1;
    public Date week3day2;
    public Date week3day3;
    public Date week3day4;
    public Date week3day5;
    public Date week3day6;
    public Date week3day7;

    public Date week4day1;
    public Date week4day2;
    public Date week4day3;
    public Date week4day4;
    public Date week4day5;
    public Date week4day6;
    public Date week4day7;

    Button BTNTodayTrain;
    Button BTNWatchPlan;
    Button BTNAboutPlan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_train_today, container, false);
        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        today = new Date();
        try {
            todayWithZeroTime = sdf.parse(sdf.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        BTNTodayTrain = (Button) rootView.findViewById(R.id.today_train_btn);
        BTNWatchPlan = (Button) rootView.findViewById(R.id.watch_plan_btn);
        BTNAboutPlan = (Button) rootView.findViewById(R.id.about_plan_btn);

        BTNTodayTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
                Intent intent = new Intent(getContext(), TrainActivity.class);
                    if (todayWithZeroTime.compareTo(week1day1)==0) {
                        SetTrain.setTrain(intent,title_train, "week1", "day1");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week1day2)==0){
                        SetTrain.setTrain(intent,title_train, "week1", "day2");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week1day3)==0){
                        SetTrain.setTrain(intent,title_train, "week1", "day3");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week1day4)==0){
                        SetTrain.setTrain(intent,title_train, "week1", "day4");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week1day5)==0){
                        SetTrain.setTrain(intent,title_train, "week1", "day5");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week1day6)==0){
                        SetTrain.setTrain(intent,title_train, "week1", "day6");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week1day7)==0){
                        SetTrain.setTrain(intent,title_train, "week1", "day7");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day1)==0) {
                        SetTrain.setTrain(intent,title_train, "week2", "day1");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day2)==0){
                        SetTrain.setTrain(intent,title_train, "week2", "day2");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day3)==0){
                        SetTrain.setTrain(intent,title_train, "week2", "day3");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day4)==0){
                        SetTrain.setTrain(intent,title_train, "week2", "day4");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day5)==0){
                        SetTrain.setTrain(intent,title_train, "week2", "day5");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day6)==0){
                        SetTrain.setTrain(intent,title_train, "week2", "day6");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week2day7)==0){
                        SetTrain.setTrain(intent,title_train, "week2", "day7");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day1)==0) {
                        SetTrain.setTrain(intent,title_train, "week3", "day1");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day2)==0){
                        SetTrain.setTrain(intent,title_train, "week3", "day2");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day3)==0){
                        SetTrain.setTrain(intent,title_train, "week3", "day3");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day4)==0){
                        SetTrain.setTrain(intent,title_train, "week3", "day4");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day5)==0){
                        SetTrain.setTrain(intent,title_train, "week3", "day5");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day6)==0){
                        SetTrain.setTrain(intent,title_train, "week3", "day6");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week3day7)==0){
                        SetTrain.setTrain(intent,title_train, "week3", "day7");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day1)==0) {
                        SetTrain.setTrain(intent,title_train, "week4", "day1");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day2)==0){
                        SetTrain.setTrain(intent,title_train, "week4", "day2");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day3)==0){
                        SetTrain.setTrain(intent,title_train, "week4", "day3");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day4)==0){
                        SetTrain.setTrain(intent,title_train, "week4", "day4");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day5)==0){
                        SetTrain.setTrain(intent,title_train, "week4", "day5");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day6)==0){
                        SetTrain.setTrain(intent,title_train, "week4", "day6");
                        startActivity(intent);
                    } else if (todayWithZeroTime.compareTo(week4day7)==0){
                        SetTrain.setTrain(intent,title_train, "week4", "day7");
                        startActivity(intent);
                    } else
                        Toast.makeText(getContext(), "Ваш план начнется " + date, Toast.LENGTH_SHORT).show();

            }
        });

        BTNWatchPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WeekActivity.class);
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        BTNAboutPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AboutPlanActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_TRAIN, title_train);
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_TRAIN)){
            title_train = mSettings.getString(APP_PREFERENCES_TRAIN,"");
            date = mSettings.getString(APP_PREFERENCES_DATE,"");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            week1day1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        week1day2 = getDate(week1day1);
        week1day3 = getDate(week1day2);
        week1day4 = getDate(week1day3);
        week1day5 = getDate(week1day4);
        week1day6 = getDate(week1day5);
        week1day7 = getDate(week1day6);

        week2day1 = getDate(week1day7);
        week2day2 = getDate(week2day1);
        week2day3 = getDate(week2day2);
        week2day4 = getDate(week2day3);
        week2day5 = getDate(week2day4);
        week2day6 = getDate(week2day5);
        week2day7 = getDate(week2day6);

        week3day1 = getDate(week2day7);
        week3day2 = getDate(week3day1);
        week3day3 = getDate(week3day2);
        week3day4 = getDate(week3day3);
        week3day5 = getDate(week3day4);
        week3day6 = getDate(week3day5);
        week3day7 = getDate(week3day6);

        week4day1 = getDate(week3day7);
        week4day2 = getDate(week4day1);
        week4day3 = getDate(week4day2);
        week4day4 = getDate(week4day3);
        week4day5 = getDate(week4day4);
        week4day6 = getDate(week4day5);
        week4day7 = getDate(week4day6);


    }

    public Date getDate(Date day){
        instance.setTime(day);
        instance.add(Calendar.DAY_OF_MONTH,1);
        day = instance.getTime();
        return day;
    }
}
