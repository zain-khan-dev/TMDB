package com.example.android.moviebuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductPage extends AppCompatActivity implements MovieListener{

    private static MovieDetail mvd;
    private RecyclerView mRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        Intent intent=getIntent();
        String id=intent.getStringExtra("movie_id");
        int movie_id=Integer.parseInt(id);
        MovieDetailController movieController=new MovieDetailController();
        ((TextView)findViewById(R.id.overview)).setText("This is changed");
        View v= LayoutInflater.from(this).inflate(R.layout.activity_product_page,null,false);
        movieController.start(v,movie_id,this);
        ImageController controller=new ImageController();
        controller.start(movie_id,this);
    }
    @Override
    public void onMovieAvailable(MovieDetail mvd)
    {
        String BASE_IMAGE_URL="https://image.tmdb.org/t/p/w500";
        if(mvd!=null) {
            ((TextView) findViewById(R.id.overview)).setText(mvd.getOverview());
            System.out.println(BASE_IMAGE_URL+mvd.getUrl());
            Picasso.with(this).load(BASE_IMAGE_URL+mvd.getUrl()).into((ImageView) findViewById(R.id.sideposter));
            ((TextView)findViewById(R.id.title)).setText(mvd.getTitle());
            ((TextView)findViewById(R.id.rating)).setText(mvd.getRating());
            ((TextView)findViewById(R.id.date)).setText(mvd.getDate());
            Picasso.with(this).load(BASE_IMAGE_URL+mvd.getBackdrop()).into((ImageView) findViewById(R.id.header));
        }
    }

    @Override
    public void onImageAvailable(ArrayList<RImage> path)
    {

        LinearLayoutManager l=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycle=findViewById(R.id.rimages);
        mRecycle.setLayoutManager(l);
        VideoAdapter mAdapter=new VideoAdapter(path);
        mRecycle.setAdapter(mAdapter);
    }
}
