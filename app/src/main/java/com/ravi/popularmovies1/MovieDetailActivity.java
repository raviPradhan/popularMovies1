package com.ravi.popularmovies1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ravi.popularmovies1.model.Movies;

public class MovieDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ImageView poster = (ImageView) findViewById(R.id.iv_detail_poster);
        TextView title = (TextView) findViewById(R.id.tv_detail_title);
        TextView averageVote = (TextView) findViewById(R.id.tv_detail_averageVote);
        TextView releaseDate = (TextView) findViewById(R.id.tv_detail_releaseDate);
        TextView summary = (TextView) findViewById(R.id.tv_detail_summary);

        Movies movieDetail = (Movies) getIntent().getSerializableExtra("detail");
        title.setText(movieDetail.getMovieName());
        averageVote.setText(String.valueOf(movieDetail.getVoteAverage()));
        releaseDate.setText(movieDetail.getReleaseDate());
        summary.setText(movieDetail.getSynopsis());
        Glide.with(this).load(movieDetail.getPosterPath()).into(poster);
    }
}
