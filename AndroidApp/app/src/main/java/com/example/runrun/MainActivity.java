package com.example.runrun;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Date time;
    private Date timeWithOutDate;
    private String setTime;
    private Date today;
    private Date todayWithZeroTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        loadFragment(new NewsFragment());

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null){
                    Intent intent = new Intent(MainActivity.this, EntryActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        };
        onTimeSet();
    }

    public void onTimeSet(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 8);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        startAlarm(c);
    }

    private void startAlarm(Calendar c){
        Intent alarmIntent = new Intent(this, NotificationMessage.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1,
                alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (c.before(Calendar.getInstance())){
            c.add(Calendar.DATE,1);
        }
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 86400000, pendingIntent);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment !=  null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){

            case R.id.navigation_home:
                fragment = new NewsFragment();
                setTitle("Лента");
                break;

            case R.id.navigation_dashboard:
                fragment = new StatFragment();
                setTitle("Статистика");
                break;

            case R.id.navigation_notifications:
                fragment = new TrainFragment();
                setTitle("Тренировки");
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}
