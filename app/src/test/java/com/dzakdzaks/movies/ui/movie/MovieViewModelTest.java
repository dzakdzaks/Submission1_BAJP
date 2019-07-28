package com.dzakdzaks.movies.ui.movie;

import com.dzakdzaks.movies.data.Movie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {

    private MovieViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void getMovies() {
        List<Movie> movies = viewModel.getMovies();
        assertNotNull(movies);
        assertEquals(11, movies.size());
    }

}