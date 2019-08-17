package com.dzakdzaks.movies.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.dzakdzaks.movieLocals.BuildConfig;
import com.dzakdzaks.movies.data.local.LocalRepository;
import com.dzakdzaks.movies.data.local.entity.MovieLocal;
import com.dzakdzaks.movies.data.remote.RemoteRepository;
import com.dzakdzaks.movies.data.remote.response.movie.Movie;
import com.dzakdzaks.movies.data.remote.response.tvshow.TvShow;
import com.dzakdzaks.movies.util.FakeDummy;
import com.dzakdzaks.movies.util.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FakePublicRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();


    private LocalRepository localRepository = Mockito.mock(LocalRepository.class);
    private RemoteRepository remoteRepository = Mockito.mock(RemoteRepository.class);
    private FakePublicRepository fakePublicRepository = new FakePublicRepository(localRepository, remoteRepository);

    private ArrayList<Movie> responseMovies = FakeDummy.generateMovie();
    private String movieId = String.valueOf(responseMovies.get(0).getId());

    private ArrayList<TvShow> responseTvShows = FakeDummy.generateTvShow();
    private String tvShowId = String.valueOf(responseTvShows.get(0).getId());


    @Test
    public void getAllMovies(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback)invocation.getArguments()[0])
                    .onMoviesReceived(responseMovies);
            return null;
        }).when(remoteRepository).getAllMovies(BuildConfig.API_KEY, BuildConfig.LANGUAGE, BuildConfig.PAGE, any(RemoteRepository.LoadMoviesCallback.class));

        List<MovieLocal> movieEntities = LiveDataTestUtil.getValue(fakePublicRepository.getAllMovies(BuildConfig.API_KEY, BuildConfig.LANGUAGE, BuildConfig.PAGE));

        verify(remoteRepository, times(1)).getAllMovies(BuildConfig.API_KEY, BuildConfig.LANGUAGE, BuildConfig.PAGE, any(RemoteRepository.LoadMoviesCallback.class));
        assertNotNull(movieEntities);
        assertEquals(responseMovies.size(), movieEntities.size());
    }

    @Test
    public void getDetailMovie(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0])
                    .onMoviesReceived(responseMovies);
            return null;
        }).when(remoteRepository).getDetailMovie(movieId, BuildConfig.API_KEY, BuildConfig.LANGUAGE, any(RemoteRepository.LoadDetailMovieCallback.class));

        MovieLocal entity = LiveDataTestUtil.getValue(fakePublicRepository.getDetailMovie(movieId, BuildConfig.API_KEY, BuildConfig.LANGUAGE));

        verify(remoteRepository, times(1)).getDetailMovie(movieId, BuildConfig.API_KEY, BuildConfig.LANGUAGE, any(RemoteRepository.LoadDetailMovieCallback.class));

        assertNotNull(entity);
        assertEquals(responseMovies.get(0).getTitle(), entity.getMovieTitle());
        assertEquals(responseMovies.get(0).getOriginalTitle(), entity.getMovieOriginalTitle());
        assertEquals(responseMovies.get(0).getOriginalLanguage(), entity.getMovieCountry());
        assertEquals(responseMovies.get(0).getOverview(), entity.getMovieOverview());
        assertEquals(responseMovies.get(0).getReleaseDate(), entity.getMovieReleaseDate());
        assertEquals(responseMovies.get(0).getPosterPath(), entity.getMovieImage());
        assertEquals(responseMovies.get(0).getBackdropPath(), entity.getMovieBackground());
        assertEquals(responseMovies.get(0).getVoteAverage(), entity.getMovieVote());
    }

}