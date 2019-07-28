package com.dzakdzaks.movies.ui.tvshow;

import androidx.test.rule.ActivityTestRule;

import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.testing.SingleFragmentActivity;
import com.dzakdzaks.movies.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TvShowFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvShowFragment tvShowFragment = new TvShowFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(tvShowFragment);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadTvShow() {
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()));
        onView(withId(R.id.rvTvShow)).check(new RecyclerViewItemCountAssertion(10));
    }
}