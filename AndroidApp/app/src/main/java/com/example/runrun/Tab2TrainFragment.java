package com.example.runrun;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2TrainFragment extends Fragment {

    public String title_train;

    public Tab2TrainFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_train_tab2, container, false);
        Button btn_train_constr = (Button) rootView.findViewById(R.id.train_constr_btn);
        btn_train_constr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TrainConstructorActivity.class);
                startActivity(intent);
            }
        });
        ImageButton btn_start_speed = (ImageButton) rootView.findViewById(R.id.start_speed_btn);
        btn_start_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseTrainActivity.class);
                title_train = "start_speed34";
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        ImageButton btn_start_endurance = (ImageButton) rootView.findViewById(R.id.start_endurance_btn);
        btn_start_endurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseTrainActivity.class);
                title_train = "start_endurance34";
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        ImageButton btn_middle_speed = (ImageButton) rootView.findViewById(R.id.middle_speed_btn);
        btn_middle_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseTrainActivity.class);
                title_train = "middle_speed45";
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        ImageButton btn_middle_endurance = (ImageButton) rootView.findViewById(R.id.middle_endurance_btn);
        btn_middle_endurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseTrainActivity.class);
                title_train = "middle_endurance45";
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        ImageButton btn_pro_speed = (ImageButton) rootView.findViewById(R.id.pro_speed_btn);
        btn_pro_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseTrainActivity.class);
                title_train = "pro_speed45";
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        ImageButton btn_pro_endurance = (ImageButton) rootView.findViewById(R.id.pro_endurance_btn);
        btn_pro_endurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseTrainActivity.class);
                title_train = "pro_endurance45";
                intent.putExtra("title_train", title_train);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
