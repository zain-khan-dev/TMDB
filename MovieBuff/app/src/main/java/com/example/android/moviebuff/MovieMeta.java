package com.example.android.moviebuff;

public class MovieMeta
{
    private String url;
    private String title;
    private int id;
    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    MovieMeta(String title,String url,int id)
    {
        this.title=title;
        this.url=url;
        this.id=id;
    }
}
