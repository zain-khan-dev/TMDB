package com.example.android.moviebuff;

import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.android.volley.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageController implements Callback<ImageMeta>{

    int id;
    ProductPage instance;
    private static String BASE_URL="https://api.themoviedb.org/3/";
    private static String API_KEY="a9d0d6ea57976acdd05705479a869bdf";

    public void start(int id,ProductPage in)
    {
        this.instance=in;
        this.id=id;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);
        Call<ImageMeta> call = gerritAPI.loadMovieImages(id,API_KEY);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ImageMeta> call, Response<ImageMeta> response)
    {
        ImageMeta mvd=response.body();

        instance.onImageAvailable(mvd.getrImage());
    }

    @Override
    public void onFailure(Call<ImageMeta> call, Throwable t) {
        t.printStackTrace();
        System.out.println("Failed");
    }
}
