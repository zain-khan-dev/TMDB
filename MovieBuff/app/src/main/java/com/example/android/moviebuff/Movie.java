package com.example.android.moviebuff;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


class Result
{
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("id")
    @Expose
    private int id;
    Result()
    {
        title="";
        poster_path="";
        id=0;
    }

    public String getOriginal_title() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public int getId() {
        return id;
    }
}


public class Movie {
    @SerializedName("results")
    @Expose
    final ArrayList<Result>result;
    final ArrayList<MovieMeta> mmv;
    Movie()
    {
        result=new ArrayList<>();
        mmv=new ArrayList<>();
    }
    ArrayList<MovieMeta> getAllTitle()
    {
        for(int i=0;i<result.size();i++)
        {
            mmv.add(new MovieMeta(result.get(i).getOriginal_title(),result.get(i).getPoster_path(),result.get(i).getId()));
        }
        return mmv;
    }
}
