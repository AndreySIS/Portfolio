package com.example.runrun;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1TrainFragment extends Fragment {

    String[] train;

    public Tab1TrainFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_train_tab1, container, false);
        ImageButton btn_start_speed_train = (ImageButton) rootView.findViewById(R.id.start_speed_train_btn);
        btn_start_speed_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getContext(), TrainActivity.class);
                    SetTrain.setTrain(intent, "start_speed34", "week1", "day1");
                    startActivity(intent);
            }
        });

        ImageButton btn_middle_speed_train = (ImageButton) rootView.findViewById(R.id.middle_speed_train_btn);
        btn_middle_speed_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "middle_speed34", "week4", "day1");
                startActivity(intent);
            }
        });

        ImageButton btn_pro_speed_train = (ImageButton) rootView.findViewById(R.id.pro_speed_train_btn);
        btn_pro_speed_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "pro_speed45", "week1", "day1");
                startActivity(intent);
            }
        });

        ImageButton btn_start_strangth_train = (ImageButton) rootView.findViewById(R.id.start_strangth_train_btn);
        btn_start_strangth_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "start_speed34", "week3", "day3");
                startActivity(intent);
            }
        });

        ImageButton btn_middle_strangth_train = (ImageButton) rootView.findViewById(R.id.middle_strangth_train_btn);
        btn_middle_strangth_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "middle_speed34", "week3", "day5");
                startActivity(intent);
            }
        });

        ImageButton btn_pro_strangth_train = (ImageButton) rootView.findViewById(R.id.pro_strangth_train_btn);
        btn_pro_strangth_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "pro_speed45", "week2", "day6");
                startActivity(intent);
            }
        });

        ImageButton btn_start_endurance_train = (ImageButton) rootView.findViewById(R.id.start_endurance_train_btn);
        btn_start_endurance_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "start_endurance34", "week1", "day3");
                startActivity(intent);
            }
        });

        ImageButton btn_middle_endurance_train = (ImageButton) rootView.findViewById(R.id.middle_endurance_train_btn);
        btn_middle_endurance_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "middle_endurance34", "week1", "day3");
                startActivity(intent);
            }
        });

        ImageButton btn_pro_endurance_train = (ImageButton) rootView.findViewById(R.id.pro_endurance_train_btn);
        btn_pro_endurance_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainActivity.class);
                SetTrain.setTrain(intent, "pro_endurance45", "week4", "day2");
                startActivity(intent);
            }
        });

        return rootView;
    }

}
