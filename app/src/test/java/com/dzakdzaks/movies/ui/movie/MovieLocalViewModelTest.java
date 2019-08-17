package com.dzakdzaks.movies.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dzakdzaks.movieLocals.BuildConfig;
import com.dzakdzaks.movies.data.PublicRepository;
import com.dzakdzaks.movies.data.local.LocalRepository;
import com.dzakdzaks.movies.data.local.entity.MovieLocal;
import com.dzakdzaks.movies.data.remote.RemoteRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieLocalViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private PublicRepository publicRepository = mock(PublicRepository.class);
    @Before
    public void setUp() {
        viewModel = new MovieViewModel(publicRepository);
        publicRepository = new PublicRepository(new LocalRepository(), new RemoteRepository());
    }

    @After
    public void tearDown() {

    }

    @Test
    public void getMovies() {

        LiveData<List<MovieLocal>> data = publicRepository.getAllMovies(BuildConfig.API_KEY, BuildConfig.LANGUAGE,BuildConfig.PAGE);
        List<MovieLocal> listData = data.getValue();

        MutableLiveData<List<MovieLocal>> movieLocals = new MutableLiveData<>();
        movieLocals.setValue(listData);

        when(data).thenReturn(movieLocals);

        Observer<List<MovieLocal>> observer = mock(Observer.class);

        viewModel.getMovies(BuildConfig.API_KEY, BuildConfig.LANGUAGE, BuildConfig.PAGE).observeForever(observer);

        verify(observer).onChanged(listData);

    }

}