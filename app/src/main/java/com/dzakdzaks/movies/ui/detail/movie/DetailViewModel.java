package com.dzakdzaks.movies.ui.detail.movie;

import androidx.lifecycle.ViewModel;

import com.dzakdzaks.movies.data.Movie;
import com.dzakdzaks.movies.utils.Dummy;

public class DetailViewModel extends ViewModel {
    private Movie mMovie;
    private String movieId;

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }


    public Movie getMovie() {
        for (int i = 0; i < Dummy.generateMovie().size(); i++) {
            Movie movie = Dummy.generateMovie().get(i);
            if (movie.getMovieId().equals(movieId)) {
                mMovie = movie;
            }
        }
        return mMovie;
    }
}
