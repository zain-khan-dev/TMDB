package com.example.android.moviebuff;

import com.google.gson.annotations.SerializedName;

public class RImage
{
    @SerializedName("key")
    private String path;

    @SerializedName("site")
    private String type;

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }
}

