package com.example.android.moviebuff;

import java.util.ArrayList;

public interface MovieListener {
    void onMovieAvailable(MovieDetail mvd);
    void onImageAvailable(ArrayList<RImage>ar);
}
