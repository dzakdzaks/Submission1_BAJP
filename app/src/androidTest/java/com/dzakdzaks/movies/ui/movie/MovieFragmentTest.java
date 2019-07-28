package com.dzakdzaks.movies.ui.movie;

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

public class MovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MovieFragment movieFragment = new MovieFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(movieFragment);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()));
        onView(withId(R.id.rvMovie)).check(new RecyclerViewItemCountAssertion(11));
    }
}