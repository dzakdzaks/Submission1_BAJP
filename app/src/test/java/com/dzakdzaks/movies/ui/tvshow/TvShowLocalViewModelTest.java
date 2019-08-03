package com.dzakdzaks.movies.ui.tvshow;

import com.dzakdzaks.movies.data.local.entity.TvShowLocal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TvShowLocalViewModelTest {
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
        List<TvShowLocal> tvShowLocals = viewModel.getTvShows();
        assertNotNull(tvShowLocals);
        assertEquals(10, tvShowLocals.size());
    }
}