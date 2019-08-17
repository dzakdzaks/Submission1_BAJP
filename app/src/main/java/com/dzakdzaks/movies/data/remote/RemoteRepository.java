package com.dzakdzaks.movies.data.remote;

import com.dzakdzaks.movies.data.remote.response.movie.Movie;
import com.dzakdzaks.movies.data.remote.response.movie.ResponseMovie;
import com.dzakdzaks.movies.data.remote.response.movie.detail.ResponseDetailMovie;
import com.dzakdzaks.movies.data.remote.response.tvshow.ResponseTvShow;
import com.dzakdzaks.movies.data.remote.response.tvshow.TvShow;
import com.dzakdzaks.movies.data.remote.response.tvshow.detail.ResponseDetailTvShow;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;

    public static RemoteRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository();
        }
        return INSTANCE;
    }

    public void getAllMovies(String apiKey, String language, String page, LoadMoviesCallback callback) {
            Call<ResponseMovie> call = ApiClient.getApi().getMovies(apiKey, language, page);
            call.enqueue(new Callback<ResponseMovie>() {
                @Override
                public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        callback.onMoviesReceived(response.body().getResults());
                    }
                }

                @Override
                public void onFailure(Call<ResponseMovie> call, Throwable t) {
                    callback.onMoviesFailedReceived();
                }
            });
    }


    public void getDetailMovie(String movieId, String apiKey, String language, LoadDetailMovieCallback callback) {
            Call<ResponseDetailMovie> call = ApiClient.getApi().getDetailMovie(movieId, apiKey, language);
            call.enqueue(new Callback<ResponseDetailMovie>() {
                @Override
                public void onResponse(Call<ResponseDetailMovie> call, Response<ResponseDetailMovie> response) {
                    callback.onDetailMovieReceived(response.body());
                }

                @Override
                public void onFailure(Call<ResponseDetailMovie> call, Throwable t) {
                    callback.onDetailMovieFailedReceived();
                }
            });
    }

    public void getAllTvShow(String apiKey, String language, String page, LoadTvShowsCallback callback) {
            Call<ResponseTvShow> call = ApiClient.getApi().getTvShows(apiKey, language, page);
            call.enqueue(new Callback<ResponseTvShow>() {
                @Override
                public void onResponse(Call<ResponseTvShow> call, Response<ResponseTvShow> response) {
                    callback.onTvShowsReceived(response.body().getResults());
                }

                @Override
                public void onFailure(Call<ResponseTvShow> call, Throwable t) {
                    callback.onTvShowsFailedReceived();
                }
            });
    }

    public void getDetailTvShow(String tvShowId, String apiKey, String language, LoadDetailTvShowCallback callback) {
            Call<ResponseDetailTvShow> call = ApiClient.getApi().getDetailTvShow(tvShowId, apiKey, language);
            call.enqueue(new Callback<ResponseDetailTvShow>() {
                @Override
                public void onResponse(Call<ResponseDetailTvShow> call, Response<ResponseDetailTvShow> response) {
                    callback.onDetailTvShowReceived(response.body());
                }

                @Override
                public void onFailure(Call<ResponseDetailTvShow> call, Throwable t) {
                    callback.onDetailTvShowsFailedReceived();
                }
            });
    }


    public interface LoadMoviesCallback {
        void onMoviesReceived(List<Movie> movies);

        void onMoviesFailedReceived();
    }

    public interface LoadDetailMovieCallback {
        void onDetailMovieReceived(ResponseDetailMovie detailMovie);

        void onDetailMovieFailedReceived();
    }

    public interface LoadTvShowsCallback {
        void onTvShowsReceived(List<TvShow> tvShows);

        void onTvShowsFailedReceived();
    }

    public interface LoadDetailTvShowCallback {
        void onDetailTvShowReceived(ResponseDetailTvShow detailTvShow);

        void onDetailTvShowsFailedReceived();
    }
}
