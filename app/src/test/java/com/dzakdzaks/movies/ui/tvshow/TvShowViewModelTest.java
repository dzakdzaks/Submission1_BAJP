package com.dzakdzaks.movies.ui.tvshow;

import com.dzakdzaks.movies.data.Movie;
import com.dzakdzaks.movies.data.TvShow;
import com.dzakdzaks.movies.ui.movie.MovieViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void getTvShow() {
        List<TvShow> tvShows = viewModel.getTvShows();
        assertNotNull(tvShows);
        assertEquals(10, tvShows.size());
    }
}