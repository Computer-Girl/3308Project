package dachman.lucas.letsgoapp2;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
        Toast.makeText(getApplicationContext(), "Maps not yet implemented", Toast.LENGTH_LONG).show();
    }

}
