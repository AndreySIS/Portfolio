package com.example.runrun;

import android.content.Intent;

public class SetTrain {

    public static void setTrain(Intent intent, String train, String week, String day){
        intent.putExtra("title_train", train);
        intent.putExtra("week", week);
        intent.putExtra("day", day);
    }
}
