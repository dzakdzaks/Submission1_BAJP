package com.dzakdzaks.movies.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dzakdzaks.movies.data.PublicRepository;
import com.dzakdzaks.movies.data.local.entity.MovieLocal;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private PublicRepository publicRepository;

    public MovieViewModel(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }

    public LiveData<List<MovieLocal>> getMovies(String apiKey, String language, String page) {
        return publicRepository.getAllMovies(apiKey, language, page);
    }
}
