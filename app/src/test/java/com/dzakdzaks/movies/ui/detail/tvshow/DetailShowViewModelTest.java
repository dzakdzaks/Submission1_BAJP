package com.dzakdzaks.movies.ui.detail.tvshow;

import com.dzakdzaks.movies.data.TvShow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DetailShowViewModelTest {
    private DetailShowViewModel viewModel;
    private TvShow dummy;


    @Before
    public void setUp() {
        viewModel = new DetailShowViewModel();
        dummy = new TvShow("60735",
                "The Flash",
                "The Flash",
                "America",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "07 October 2014",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                6.7);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDetailTvShow() {
        viewModel.setTvShowId(dummy.getTvShowId());
        TvShow tvShow = viewModel.getTvShow();
        assertNotNull(tvShow);
        assertEquals(dummy.getTvShowId(), tvShow.getTvShowId());
        assertEquals(dummy.getTvShowTitle(), tvShow.getTvShowTitle());
        assertEquals(dummy.getTvShowOriginalTitle(), tvShow.getTvShowOriginalTitle());
        assertEquals(dummy.getTvShowCountry(), tvShow.getTvShowCountry());
        assertEquals(dummy.getTvShowOverview(), tvShow.getTvShowOverview());
        assertEquals(dummy.getTvShowReleaseDate(), tvShow.getTvShowReleaseDate());
        assertEquals(dummy.getTvShowImage(), tvShow.getTvShowImage());
        assertEquals(String.valueOf(dummy.getTvShowVote()), String.valueOf(tvShow.getTvShowVote()));
    }
}