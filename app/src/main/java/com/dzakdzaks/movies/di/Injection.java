package com.dzakdzaks.movies.di;

import com.dzakdzaks.movies.data.PublicDataSource;
import com.dzakdzaks.movies.data.PublicRepository;
import com.dzakdzaks.movies.data.local.LocalRepository;
import com.dzakdzaks.movies.data.remote.RemoteRepository;

public class Injection {
    public static PublicRepository provideRepository() {
        LocalRepository localRepository = new LocalRepository();
        RemoteRepository remoteRepository = RemoteRepository.getInstance();

        return PublicRepository.getInstance(localRepository, remoteRepository);
    }
}
