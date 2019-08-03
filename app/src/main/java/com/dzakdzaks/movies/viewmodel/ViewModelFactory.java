package com.dzakdzaks.movies.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dzakdzaks.movies.data.PublicRepository;
import com.dzakdzaks.movies.di.Injection;
import com.dzakdzaks.movies.ui.detail.movie.DetailViewModel;
import com.dzakdzaks.movies.ui.detail.tvshow.DetailShowViewModel;
import com.dzakdzaks.movies.ui.movie.MovieViewModel;
import com.dzakdzaks.movies.ui.tvshow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final PublicRepository publicRepository;

    public ViewModelFactory(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }

    public static ViewModelFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository());
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(publicRepository);
        } else if (modelClass.isAssignableFrom(DetailShowViewModel.class)) {
            return (T) new DetailShowViewModel(publicRepository);
        } else if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(publicRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(publicRepository);
        }

        throw new IllegalArgumentException("ViewModel dengan nama " + modelClass.getName() + " tidak ditemukan.");
    }


}
