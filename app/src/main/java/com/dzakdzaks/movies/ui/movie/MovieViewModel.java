package com.dzakdzaks.movies.ui.movie;

import androidx.lifecycle.ViewModel;

import com.dzakdzaks.movies.data.Movie;
import com.dzakdzaks.movies.utils.Dummy;

import java.util.List;

public class MovieViewModel extends ViewModel {
    public List<Movie> getMovies() {
        return Dummy.generateMovie();
    }
}
