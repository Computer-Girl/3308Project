package dachman.lucas.letsgoapp2;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.intent.IntentMonitor;
import android.test.TouchUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import dachman.lucas.letsgoapp2.TabbedEventListActivity;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.R.attr.button;
import static android.R.attr.targetActivity;
import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Jasmine on 4/5/2017.
 */

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new
            ActivityTestRule<LoginActivity>(LoginActivity.class);

    /**@version 1
     * @author Jasmine
     * This test case tests whether or not the app opens up correctly to the login screen
    *and allows the user access to our test button to enter the app successfully to
    * the next activity, also tests facets of the UI for the login activity
     */
    @Test
    public void testCase1UI()
    {
//series of tests for the UI of the login screen, are the text views there?
//are the buttons that need to be accessbile for the user shown? . . checked here
        Activity activity = loginActivityActivityTestRule.getActivity();

        TextView titleView = (TextView) activity.findViewById(R.id.title_text);

        assertTrue(titleView.isShown());

        assertEquals(InstrumentationRegistry.getTargetContext().getString(R.string.title_text), titleView.getText());

        assertNotNull(activity.findViewById(R.id.test_button));

        assertNotNull(activity.findViewById(R.id.sign_in_button));

        assertNotNull(activity.findViewById(R.id.sign_in_button));

        assertNotNull(activity.findViewById(R.id.sign_in_button));



    }

    /**
     * @version 1
     * @author Jasmine
     * checks to see if next activiyt opens correctly and if its textviews pull
     * up for user
     */
    @Test
    public void testOpenNextActivity() {
        //have to register the next activity to monitor it and see if it pulls up

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(TabbedEventListActivity.class.getName(), null, false);

        //this opens the current activity, which is login
        EventViewActivity myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(R.id.test_button);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //this clicks the button to go to the next activity
                button.performClick();
            }
        });

        //this watches for timeout, makes sure it doesn't take too long to load next activity
        TabbedEventListActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);

        //this captures the next activity and asserts that it is not null, meaning that it exists
        //and successfully was opened
        assertNotNull(nextActivity);
        nextActivity .finish();
    }

}
