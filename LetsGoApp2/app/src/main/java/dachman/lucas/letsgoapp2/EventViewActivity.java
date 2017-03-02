package dachman.lucas.letsgoapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class EventViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populateViews(getApplicationContext());
    }

    private void populateViews(Context context) {
        Event currentEvent = getIntent().getParcelableExtra("Event");

        TextView date = (TextView) findViewById(R.id.event_view_date);
        TextView location = (TextView) findViewById(R.id.event_view_location);

        String dateString = DateFormat.getDateInstance().format(currentEvent.getDate());
        date.setText(dateString);
        location.setText(currentEvent.getLocation());
        getSupportActionBar().setTitle(currentEvent.getName());
    }

}
