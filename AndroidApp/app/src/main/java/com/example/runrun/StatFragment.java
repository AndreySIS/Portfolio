package com.example.runrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StatFragment extends Fragment {


    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabase;

    private RecyclerView mTrainList;
    private FloatingActionButton Btn_open;

    public StatFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        Btn_open = (FloatingActionButton) rootView.findViewById(R.id.open_floatingActionButton);
        Btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddTrainActivity.class);
                startActivity(intent);
            }
        });

        mAuth = FirebaseAuth.getInstance();

        mCurrentUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Train").child(mCurrentUser.getUid());

        mTrainList = (RecyclerView) rootView.findViewById(R.id.train_list);
        mTrainList.setHasFixedSize(true);
        mTrainList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Train, StatFragment.TrainViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Train, StatFragment.TrainViewHolder>(

                Train.class,
                R.layout.train_row,
                StatFragment.TrainViewHolder.class,
                mDatabase

        ) {
            @Override
            protected void populateViewHolder(StatFragment.TrainViewHolder viewHolder, Train model, int position) {

                viewHolder.setDist(model.getDist());
                viewHolder.setTime(model.getTime());
                viewHolder.setDate(model.getDate());

            }
        };

        mTrainList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class TrainViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public TrainViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setDist(String dist){

            TextView train_dist = (TextView) mView.findViewById(R.id.train_dist);
            train_dist.setText(dist + " м");
        }

        public void setTime(String time){

            TextView train_time = (TextView) mView.findViewById(R.id.train_time);
            train_time.setText(time + "мин");
        }

        public void setDate(String date){

            TextView train_date = (TextView) mView.findViewById(R.id.train_date);
            train_date.setText(date);
        }


    }


}
