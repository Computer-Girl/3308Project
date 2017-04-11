package dachman.lucas.letsgoapp2;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;

import dachman.lucas.letsgoapp2.Models.Event;

public class EventViewActivity extends AppCompatActivity {

    // Currently shown event
    Event currentEvent;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Set current shown event
        currentEvent = getIntent().getParcelableExtra("Event");
        // Set up floating action button, "star button"
        setUpStarButton();
        // Set text fields and stuff
        populateViews();
    }

    private void setUpStarButton() {
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.star_button);

        changeStarIcon(fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Implement Star Feature", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // Make event starred/unstarred
                boolean isStarred = currentEvent.isShowAsStarred();
                currentEvent.setShowAsStarred(!isStarred);
                changeStarIcon(fab);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void changeStarIcon(FloatingActionButton fab) {

        boolean isStarred = currentEvent.isShowAsStarred();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (isStarred) {
                fab.setImageDrawable(getDrawable(R.drawable.ic_star_gold_24dp));
            }
            else {
                fab.setImageDrawable(getDrawable(R.drawable.ic_star_border_white_24dp));
            }
        }
    }
    private void populateViews() {

        TextView date = (TextView) findViewById(R.id.event_view_date);
        TextView location = (TextView) findViewById(R.id.event_view_location);
        TextView description = (TextView) findViewById(R.id.event_view_description);
        TextView organizerName = (TextView) findViewById(R.id.event_view_organizerName);

        // Set Text for Date TextView
        String dateString = DateFormat.getDateInstance().format(currentEvent.getDate());
        date.setText(dateString);
        //Set Text for location TextView
        location.setText(currentEvent.getLocation());
        //Set Text for description TextView
        description.setText(currentEvent.getDescription());
        //Set Text for Organizer Name
        organizerName.setText(currentEvent.getOrganizerName());
        //Set Toolbar title to current event Name
        getSupportActionBar().setTitle(currentEvent.getName());
    }

    public void onClickMap(View view) {
        //TODO: Start map activity or fragment
        getPermission();
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("Event", currentEvent);
            startActivity(intent);

    }

    public void getPermission() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

}
