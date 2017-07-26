package com.lithub.team8.wheresmystuff;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lithub.team8.wheresmystuff.R;

import com.lithub.team8.wheresmystuff.controller.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private final String[] errors = {"This field is required","This email address is invalid","",""};
    private final String[] errors2 = {"","","This password is too short", "This password is too short"};
    private final String[] usernames = {"","name","name@gmail.com", "name@gmail.com"};
    private final String[] passwords = {"",""," ","asdf"};
    @Rule
    public final ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);

    /**
     * Tests if LoginActivity checks if username and password have been entered
     * when clicked
     */
    @Test
    public void signInTest() throws InterruptedException {
        rule.launchActivity(new Intent());
        ViewInteraction emailText = onView(withId(R.id.email));
        ViewInteraction passText = onView(withId(R.id.password));

        for(int i = 0; i < 4; i++) {
            onView(withId(R.id.email)).perform(replaceText(usernames[i]));
            onView(withId(R.id.password)).perform(replaceText(passwords[i]));
            onView(withId(R.id.email_sign_in_button)).perform(click());
            if(i < 2) emailText.check(matches(hasErrorText(errors[i])));
            if(i > 1) passText.check(matches(hasErrorText(errors2[i])));
        }
    }
}
