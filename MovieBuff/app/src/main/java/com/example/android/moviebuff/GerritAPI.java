package com.example.android.moviebuff;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GerritAPI {

    @GET("movie/popular/")
    Call<Movie> loadMovie( @Query("api_key") String key,@Query("page") int page);
    @GET("movie/{movie_id}")
    Call<MovieDetail> loadSingleMovie(@Path("movie_id") int movie_id,@Query("api_key") String key);
    @GET("movie/{movie_id}/videos")
    Call<ImageMeta> loadMovieImages(@Path("movie_id") int movie_id,@Query("api_key") String key);

}
