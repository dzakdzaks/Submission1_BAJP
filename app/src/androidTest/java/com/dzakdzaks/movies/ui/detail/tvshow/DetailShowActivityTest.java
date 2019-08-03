package com.dzakdzaks.movies.ui.detail.tvshow;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.data.local.entity.TvShowLocal;
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

public class DetailShowActivityTest {
    private TvShowLocal dummy = FakeDummy.generateTvShow().get(0);

    @Rule
    public ActivityTestRule<DetailShowActivity> activityTestRule = new ActivityTestRule<DetailShowActivity>(DetailShowActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailShowActivity.class);
            result.putExtra(DetailShowActivity.EXTRA_TV_SHOW, dummy.getTvShowId());
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
    public void loadTvShow() {
        onView(withId(R.id.textTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textTitle)).check(matches(withText(dummy.getTvShowTitle())));
        onView(withId(R.id.textOriginalTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textOriginalTitle)).check(matches(withText(dummy.getTvShowOriginalTitle())));
    }

}