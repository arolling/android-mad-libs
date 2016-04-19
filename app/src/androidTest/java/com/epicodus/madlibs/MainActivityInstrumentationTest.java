package com.epicodus.madlibs;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


/**
 * Created by Guest on 4/19/16.
 */
public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText(){
        onView(withId(R.id.tfPlace)).perform(typeText("Montana"))
                .check(matches(withText("Montana")));
    }

    @Test
    public void inputIsSentToStoryActivity(){
        String place = "Mexico";
        onView(withId(R.id.tfPlace)).perform(typeText(place));
        onView(withId(R.id.btnCreateStory)).perform(click());
        onView(withId(R.id.storyHolder)).check(matches(withText(containsString("Mexico"))));
    }

    @Test
    public void spinnerIsDisplayed(){
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
    }

    @Test
    public void selectedSpinnerIsSelected() {
        String place = "Mexico";
        onView(withId(R.id.tfPlace)).perform(typeText(place));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Coding"))).perform(click());
        onView(withId(R.id.btnCreateStory)).perform(click());
        onView(withId(R.id.tvResultsHeader)).check(matches(withText(containsString("Coding"))));
    }
}
