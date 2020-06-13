package com.example.android.moviebuff;

import com.google.gson.annotations.SerializedName;

public class MovieDetail {

    @SerializedName("overview")
    private String overview;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String url;

    @SerializedName("vote_average")
    private String rating;

    @SerializedName("release_date")
    private String date;

    @SerializedName("backdrop_path")
    private String backdrop;


    public String getBackdrop() {
        return backdrop;
    }

    public String getDate() {
        return date;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getRating() {
        return rating;
    }
}
