package com.dzakdzaks.movies.ui.tvshow;

import androidx.lifecycle.ViewModel;

import com.dzakdzaks.movies.data.TvShow;
import com.dzakdzaks.movies.utils.Dummy;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    public List<TvShow> getTvShows() {
        return Dummy.generateTvShow();
    }
}
