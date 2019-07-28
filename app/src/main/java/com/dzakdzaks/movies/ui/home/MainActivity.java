package com.dzakdzaks.movies.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.ui.movie.MovieFragment;
import com.dzakdzaks.movies.ui.tvshow.TvShowFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setSupportActionBar(toolbar);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new MovieFragment(), "Movies");
        adapter.addFragment(new TvShowFragment(), "TV Shows");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
