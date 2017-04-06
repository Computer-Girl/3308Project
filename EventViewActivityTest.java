package dachman.lucas.letsgoapp2;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jrethmann on 4/5/2017.
 */

/*This test case tests the Event view activity for our app that displays
*all the information for a specific event on.  This will test to see if 
*the event view's UI is correct for the user, and if this activity
*correctly opens up for the maps API
*/

@RunWith(AndroidJUnit4.class)
public class EventViewActivityTest {

    @Rule
    public ActivityTestRule<EventViewActivity> eventViewActivityActivityTestRule = new
            ActivityTestRule<EventViewActivity>(EventViewActivity.class);


    @Test
    public void testCase2UI()
    {
//checks for UI, such as text views, the buttons toolbar for the user. . 
        Activity activity = eventViewActivityActivityTestRule.getActivity();

        assertNotNull(activity.findViewById(R.id.Google_plus));

        assertNotNull(activity.findViewById(R.id.star_button));

        assertNotNull(activity.findViewById(R.id.content_event_view));

        TextView nameView = (TextView) activity.findViewById(R.id.event_view_organizerName);
        TextView dateView = (TextView) activity.findViewById(R.id.event_view_date);
        TextView locationView = (TextView) activity.findViewById(R.id.event_view_location);
        TextView depView = (TextView) activity.findViewById(R.id.event_view_description);

        assertTrue(nameView.isShown());
        assertTrue(dateView.isShown());
        assertTrue(locationView.isShown());
        assertTrue(depView.isShown());



    }

    public void testOpenNextActivity() {
        
//the only way to open up the next activity is to put a monitor on it
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MapActivity.class.getName(), null, false);

        ///have to open the current activity that we're on
        EventViewActivity myActivity = getActivity();
//button to press to go to new activity
        final Button button = (Button) myActivity.findViewById(R.id.map_button);
        myActivity.runOnUiThread(new Runnable() {
		//will click button to open up new activity
            @Override
            public void run() {
               
                button.performClick();
            }
        });

        //this watches the timeout to make sure activity isn't taking too long to load
        MapActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
       
//if the activity is correctly opened, then it will be captured and used with the assertNotNull method
//to show that the activity opened successfully and therefore exists
        assertNotNull(nextActivity);
        nextActivity .finish();
    }

}
