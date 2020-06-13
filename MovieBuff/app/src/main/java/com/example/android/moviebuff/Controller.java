package com.example.android.moviebuff;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class Controller implements Callback<Movie> {

    static final String API_KEY="a9d0d6ea57976acdd05705479a869bdf";
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static ArrayList<MovieMeta>movies;
    static MyAdapter mAdapter;
    public void start(MyAdapter mAdapter) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        this.mAdapter=mAdapter;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);
        Call<Movie> call = gerritAPI.loadMovie(API_KEY,1);
        call.enqueue(this);
    }
    @Override
    public void onResponse(Call<Movie> call, Response<Movie> response) {
        Movie mv=response.body();
        movies=mv.getAllTitle();
        mAdapter.setData(movies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Call<Movie> call, Throwable t) {
        t.printStackTrace();
    }
}