package dachman.lucas.letsgoapp2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

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

        String dateString = DateFormat.getDateInstance().format(currentEvent.getDate());
        date.setText(dateString);
        location.setText(currentEvent.getLocation());
        getSupportActionBar().setTitle(currentEvent.getName());
    }

}
