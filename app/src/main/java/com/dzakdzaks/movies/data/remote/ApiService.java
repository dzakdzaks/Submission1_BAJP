package com.dzakdzaks.movies.data.remote;

import com.dzakdzaks.movies.data.remote.response.movie.ResponseMovie;
import com.dzakdzaks.movies.data.remote.response.movie.detail.ResponseDetailMovie;
import com.dzakdzaks.movies.data.remote.response.tvshow.ResponseTvShow;
import com.dzakdzaks.movies.data.remote.response.tvshow.detail.ResponseDetailTvShow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/now_playing")
    Call<ResponseMovie> getMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") String page
    );

    @GET("movie/{movie_id}")
    Call<ResponseDetailMovie> getDetailMovie(
            @Path("movie_id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );


    @GET("tv/top_rated")
    Call<ResponseTvShow> getTvShows(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") String page
    );

    @GET("tv/{tv_id}")
    Call<ResponseDetailTvShow> getDetailTvShow(
            @Path("tv_id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );

}
