package dachman.lucas.letsgoapp2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import dachman.lucas.letsgoapp2.Adapters.mFragmentPagerAdapter;
import dachman.lucas.letsgoapp2.Models.Category;

public class TabbedEventListActivity extends AppCompatActivity {

    private GoogleApiClient mGoogleApiClient;


    /**
     * function onCreate
     * @param savedInstanceState
     * sets content views, categories for events, and viewpager
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_event_list);

        // The array pages is a list of strings corresponding to each tab
        Category [] categories = Category.values();
        String [] pages = new String [categories.length+1];
        pages[0] = "Starred";
        for(int i = 1; i < pages.length; i++) {
            pages[i] = categories[i-1].name();
        }

        // Get the view pager and set its adapter

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new mFragmentPagerAdapter(getSupportFragmentManager(), pages));

        // Give Tab Layout the view pager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
    }

    /**
     * function onCreateOptionsMenu
     * @param menu
     * @return boolean
     * Menu icons are inflated just as they were with actionbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * function onStart
     * intializes db with Google sign in API
     */
    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }

    /**
     * function onOptionsItemSelected
     * @param item
     * @return booelan
     * allows user to logout top right corner button
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            // Add logout method here.
            signOut();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // [START signOut]
    /**
     *
     * starts the sign out process thru google sing in API
     */
    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        //updateUI(false);
                        // [END_EXCLUDE]
                        Intent logoutIntent = new Intent(TabbedEventListActivity.this, LoginActivity.class);
                        startActivity(logoutIntent);
                        finish();
                    }
                });
    }
    // [END signOut]
}
