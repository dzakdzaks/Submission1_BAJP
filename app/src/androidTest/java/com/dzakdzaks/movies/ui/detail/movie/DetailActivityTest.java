package com.dzakdzaks.movies.ui.detail.movie;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.data.Movie;
import com.dzakdzaks.movies.utils.FakeDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {

    private Movie dummy = FakeDummy.generateMovie().get(0);

    @Rule
    public ActivityTestRule<DetailActivity> activityTestRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailActivity.class);
            result.putExtra(DetailActivity.EXTRA_MOVIE, dummy.getMovieId());
            return result;
        }
    };

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.textTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textTitle)).check(matches(withText(dummy.getMovieTitle())));
        onView(withId(R.id.textOriginalTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textOriginalTitle)).check(matches(withText(dummy.getMovieOriginalTitle())));
    }
}