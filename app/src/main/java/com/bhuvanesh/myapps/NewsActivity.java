package com.bhuvanesh.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    TextView tvDisplayNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        tvDisplayNews = (TextView) findViewById(R.id.tvDisplayNews);

        Intent newsReceived = getIntent();
        String newsInfo = newsReceived.getStringExtra(MainActivity.NEWS_KEY);
        tvDisplayNews.setText(newsInfo);
    }

}
