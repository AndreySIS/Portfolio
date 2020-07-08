package com.example.runrun;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TrainFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager firstViewPager;

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public static final String APP_PREFERENCES_DATE = "date";
    public SharedPreferences mSettings;

    public Calendar instance = Calendar.getInstance();
    public  int key;
    private String date;
    private Date dateDate;
    private Date endDate;
    public Date today;
    public Date todayWithZeroTime;

    private FragmentActivity myContext;

    public TrainFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);

        firstViewPager = (ViewPager) rootView.findViewById(R.id.viewpager_content);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(firstViewPager);

        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);


        return rootView;
    }

    private void setupViewPager(ViewPager viewPager, int key, Date endDate) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getChildFragmentManager());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        today = new Date();
        try {
            todayWithZeroTime = sdf.parse(sdf.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        adapter.addFragment(new Tab1TrainFragment(), "Тренировка");
        adapter.addFragment(new Tab2TrainFragment(), "Программа");
        if (key==1 && todayWithZeroTime.before(endDate)) {
            adapter.addFragment(new TrainTodayFragment(), "Мой план");
        }
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPause(){
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
            date = mSettings.getString(APP_PREFERENCES_DATE,"");
            setupViewPager(firstViewPager, key, getDate(date));

        }
    }

    public Date getDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        if (date.compareTo("") != 0 ) {
            try {
                dateDate = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            instance.setTime(dateDate);
            instance.add(Calendar.DAY_OF_MONTH, 28);
            endDate = instance.getTime();
        }
        else {
            try {
                endDate = sdf.parse("01.01.1970");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ;
        return endDate;
    }

}

