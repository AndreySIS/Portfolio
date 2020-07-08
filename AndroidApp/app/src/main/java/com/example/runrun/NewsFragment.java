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

public class NewsFragment extends Fragment {

    String title;
    String news;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton btn_news_new_sneakers = (ImageButton) rootView.findViewById(R.id.news_new_sneakers_btn);
        btn_news_new_sneakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewsActivity.class);
                title = "1";
                intent.putExtra("title", title);
                news = getResources().getString(R.string.News_new_sneakers);
                intent.putExtra("news", news);
                startActivity(intent);
            }
        });

        ImageButton btn_news_motivation = (ImageButton) rootView.findViewById(R.id.news_motivation_btn);
        btn_news_motivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewsActivity.class);
                title = "2";
                intent.putExtra("title", title);
                news = getResources().getString(R.string.News_motivation);
                intent.putExtra("news", news);
                startActivity(intent);
            }
        });

        ImageButton btn_news_how_to_run_longer = (ImageButton) rootView.findViewById(R.id.news_how_to_run_longer_btn);
        btn_news_how_to_run_longer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewsActivity.class);
                title = "3";
                intent.putExtra("title", title);
                news = getResources().getString(R.string.News_how_to_run_longer);
                intent.putExtra("news", news);
                startActivity(intent);
            }
        });

        ImageButton btn_News_jump_superman_btn = (ImageButton) rootView.findViewById(R.id.News_jump_superman_btn);
        btn_News_jump_superman_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewsActivity.class);
                title = "4";
                intent.putExtra("title", title);
                news = getResources().getString(R.string.News_jump_superman);
                intent.putExtra("news", news);
                startActivity(intent);
            }
        });

        return rootView;
    }


}
