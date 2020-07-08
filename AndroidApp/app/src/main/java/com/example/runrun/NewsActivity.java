package com.example.runrun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    TextView txt_news;
    ImageView image_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        txt_news = (TextView) findViewById(R.id.news_txt);
        image_news = (ImageView) findViewById(R.id.news_image);

        String title = getIntent().getExtras().getString("title");
        String news = getIntent().getExtras().getString("news");
        txt_news.setText(news);
        if (title.equals("1")){
            image_news.setImageResource(R.drawable.news2);
        } else if (title.equals("2")){
            image_news.setImageResource(R.drawable.news4);
        } else if (title.equals("3")){
            image_news.setImageResource(R.drawable.news3);
        } else if (title.equals("4")) {
            image_news.setImageResource(R.drawable.news1);
        }

    }
}
