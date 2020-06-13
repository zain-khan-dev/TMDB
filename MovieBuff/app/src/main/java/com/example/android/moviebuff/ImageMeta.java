package com.example.android.moviebuff;

import android.util.Pair;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;




public class ImageMeta
{
    @SerializedName("results")
    private ArrayList<RImage>rImage;

    public ArrayList<RImage> getrImage() {
        return rImage;
    }

}
