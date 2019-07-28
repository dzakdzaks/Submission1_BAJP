package com.dzakdzaks.movies.ui.detail.tvshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.data.TvShow;
import com.dzakdzaks.movies.utils.GlideApp;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailShowActivity extends AppCompatActivity {

    public static final String EXTRA_TV_SHOW = "extra_tv_show";
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView imgThumb;
    private ImageView imgPoster;
    private TextView txtTitle;
    private TextView txtOriginTitle;
    private TextView txtReleaseDate;
    private TextView txtVoteAverage;
    private TextView txtCountry;
    private TextView txtOverview;
    private DetailShowViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);
        viewModel = ViewModelProviders.of(this).get(DetailShowViewModel.class);
        setInit();
        setupActionBar();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_TV_SHOW);
            if (courseId != null) {
                viewModel.setTvShowId(courseId);
            }
        }

        if (viewModel.getTvShow() != null) {
            showTvShow(viewModel.getTvShow());
        }


    }

    private void setInit() {
        toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.appbar);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        imgThumb = findViewById(R.id.imgThumb);
        imgPoster = findViewById(R.id.imgPoster);
        txtTitle = findViewById(R.id.textTitle);
        txtOriginTitle = findViewById(R.id.textOriginalTitle);
        txtReleaseDate = findViewById(R.id.textReleaseDate);
        txtVoteAverage = findViewById(R.id.textVoteAverage);
        txtCountry = findViewById(R.id.textCountry);
        txtOverview = findViewById(R.id.textOverview);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showTvShow(TvShow tvShow) {
        collapsingToolbarLayout.setTitle(tvShow.getTvShowTitle());
        setupActionBar();
        GlideApp.with(getApplicationContext())
                .load(tvShow.getTvShowImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_error))
                .into(imgThumb);
        GlideApp.with(getApplicationContext())
                .load(tvShow.getTvShowImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_error))
                .into(imgPoster);
        txtTitle.setText(tvShow.getTvShowTitle());
        txtOriginTitle.setText(tvShow.getTvShowOriginalTitle());
        txtReleaseDate.setText(tvShow.getTvShowReleaseDate());
        txtVoteAverage.setText(tvShow.getTvShowVote() + "/10");
        txtCountry.setText(tvShow.getTvShowCountry());
        txtOverview.setText(tvShow.getTvShowOverview());
    }

}
