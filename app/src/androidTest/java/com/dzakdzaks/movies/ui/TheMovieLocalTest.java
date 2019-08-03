package com.dzakdzaks.movies.ui;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.ui.home.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TheMovieLocalTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void toDetailActivityTest() {

        delayTime();

        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()));
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition(4));

        delayTime();

        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));

        delayTime();

        onView(withId(R.id.textTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textTitle)).check(matches(withText("Your Name.")));

        delayTime();

        pressBackCustom();

        delayTime();

        onView(withId(R.id.viewPager)).perform(swipeLeft());

        delayTime();

        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()));
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition(4));

        delayTime();

        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));

        delayTime();

        onView(withId(R.id.textTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textTitle)).check(matches(withText("Stranger Things")));

        delayTime();

        pressBackCustom();

        delayTime();

        onView(withId(R.id.viewPager)).perform(swipeRight());

        delayTime();

    }


    private void delayTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void pressBackCustom() {
        onView(isRoot()).perform(pressBack());
    }
}
