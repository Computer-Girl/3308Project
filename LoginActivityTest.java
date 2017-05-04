package dachman.lucas.letsgoapp2;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

// This test is to demonstrate basic user login and log out functionality using Espresso Test
// Recorder, a UI testing tool provided by Android Studio.

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);


    /**
     * @version 1
     * @author Jonathan
     *
     *  This is an example of an Instrumented Test, a test of basic UI login/logout functionality
     *  under the conditions of android's Virtual Hardware Device platform.
     */
    @Test
    public void loginActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withText("Start (For Testing)"), isDisplayed()));
        appCompatButton.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Sign Out"), isDisplayed()));
        appCompatTextView.perform(click());

    }

}
