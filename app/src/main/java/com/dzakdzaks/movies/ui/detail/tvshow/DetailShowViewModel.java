package com.dzakdzaks.movies.ui.detail.tvshow;

import androidx.lifecycle.ViewModel;

import com.dzakdzaks.movies.data.TvShow;
import com.dzakdzaks.movies.utils.Dummy;

public class DetailShowViewModel extends ViewModel {
    private TvShow mTvShow;
    private String tvShowId;


    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }

    public TvShow getTvShow() {
        for (int i = 0; i < Dummy.generateTvShow().size(); i++) {
            TvShow tvShow = Dummy.generateTvShow().get(i);
            if (tvShow.getTvShowId().equals(tvShowId)) {
                mTvShow = tvShow;
            }
        }
        return mTvShow;
    }
}
