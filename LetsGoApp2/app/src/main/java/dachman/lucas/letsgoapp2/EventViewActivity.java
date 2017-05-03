package dachman.lucas.letsgoapp2;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
    public static final int MY_PERMISSIONS_REQUEST_LOCATION =1;

    //ADDED********
    //database
    CreateDatabase starDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ADDED*************
        starDB = new CreateDatabase (this);

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

    //star repo JR 4/8
    private void setUpStarButton() {
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.star_button);

        changeStarIcon(fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            //ADDED********

            public void onClick(View view) {

                String ID = Integer.toString( currentEvent.getId());
                //String ID = currentEvent.getId().toString(ID);

                int starUpdate = starDB.UpdateDatabaseStar(ID, currentEvent.getName());

                if (starUpdate == 1)
                {
                    boolean isStarred = currentEvent.isStarred();
                    currentEvent.setStarred(!isStarred);
                    changeStarIcon(fab);
                    Toast.makeText(getApplicationContext(), "Event Updated", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }
                //Snackbar.make(view, "Implement Star Feature", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                // Make event starred/unstarred

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void changeStarIcon(FloatingActionButton fab) {

        boolean isStarred = currentEvent.isStarred();
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
    //Start map activity or fragment
    public void onClickMap(View view) {
        getPermission();
        if(ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("Event", currentEvent);
            startActivity(intent);
        }

    }

    public void getPermission() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

}
