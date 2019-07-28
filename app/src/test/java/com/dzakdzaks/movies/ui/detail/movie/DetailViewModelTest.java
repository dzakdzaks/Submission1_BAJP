package com.dzakdzaks.movies.ui.detail.movie;

import com.dzakdzaks.movies.data.Movie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {

    private DetailViewModel viewModel;
    private Movie dummy;


    @Before
    public void setUp() {
        viewModel = new DetailViewModel();
        dummy = new Movie("19404",
                "Dilwale Dulhania Le Jayenge",
                "दिलवाले दुल्हनिया ले जायेंगे",
                "India",
                "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
                "20 October 1995",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg",
                9);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDetailMovie() {
        viewModel.setMovieId(dummy.getMovieId());
        Movie movie = viewModel.getMovie();
        assertNotNull(movie);
        assertEquals(dummy.getMovieId(), movie.getMovieId());
        assertEquals(dummy.getMovieTitle(), movie.getMovieTitle());
        assertEquals(dummy.getMovieOriginalTitle(), movie.getMovieOriginalTitle());
        assertEquals(dummy.getMovieCountry(), movie.getMovieCountry());
        assertEquals(dummy.getMovieOverview(), movie.getMovieOverview());
        assertEquals(dummy.getMovieReleaseDate(), movie.getMovieReleaseDate());
        assertEquals(dummy.getMovieImage(), movie.getMovieImage());
        assertEquals(String.valueOf(dummy.getMovieVote()), String.valueOf(movie.getMovieVote()));
    }

}