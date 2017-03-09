package dachman.lucas.letsgoapp2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import dachman.lucas.letsgoapp2.Adapters.EventListRecyclerAdapter;
import dachman.lucas.letsgoapp2.Models.Event;

public class EventListActivity extends AppCompatActivity {

    private ArrayList<Event> events;
    private RecyclerView recyclerView;
    private EventListRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        addEventsToList(getApplicationContext());
    }

    public void addEventsToList(Context context) {

        /*
        TODO:

        In order to populate the list view we need a
        class that can access the database and create
        an array of Event objects to pass to the
        EventListRecyclerAdapter.

         */

        // list of Events used to populate Recycler View
        events = new ArrayList<Event>();

        // TODO: delete this
        // Arbitrary Event objects for demo:
        final int MILLIS_IN_DAY = 86400000;
        for(int i=0; i < 20; i++) {
            Event e = new Event(i, "Event "+i, "UMC", new Date(System.currentTimeMillis()+i*MILLIS_IN_DAY));
            events.add(e);
        }


        recyclerView = (RecyclerView) findViewById(R.id.event_list_fragment_RecyclerView);
        adapter = new EventListRecyclerAdapter(context, events);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

    }

}


