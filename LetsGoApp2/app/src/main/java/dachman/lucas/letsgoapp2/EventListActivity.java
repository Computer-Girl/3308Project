package dachman.lucas.letsgoapp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

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

        events = new ArrayList<Event>();
        Event event1 = new Event();
        Event event2 = new Event();
        event1.setName("Event1");
        event2.setName("Event 2");
        events.add(event1);
        events.add(event2);


        recyclerView = (RecyclerView) findViewById(R.id.event_list_RecyclerView);
        adapter = new EventListRecyclerAdapter(context, events);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

    }

}

class EventListRecyclerAdapter extends RecyclerView.Adapter<EventListRecyclerAdapter.EventListViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Event> eventsList;

    public EventListRecyclerAdapter(Context context, ArrayList<Event> _eventsList) {

        inflater = LayoutInflater.from(context);
        eventsList = _eventsList;
    }

    @Override
    public EventListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_list_row_layout, parent, false);
        EventListViewHolder holder = new EventListViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(EventListViewHolder holder, int position) {
        Event currentEvent = eventsList.get(position);
        holder.eventNameView.setText(currentEvent.getName());

        //set id of itemView to corespond to Event Object in eventList
        holder.itemView.setId(position);

  }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }


    class EventListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView eventNameView;

        public EventListViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.event_list_row_Image);
            eventNameView = (TextView) itemView.findViewById(R.id.event_list_row_EventName);
            //set onClick listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // v.id corresponds to item in eventList
            Event e = eventsList.get(v.getId());
            Log.d("onClick", "You clicked the button, ID: " + v.getId());
            Intent intent = new Intent(v.getContext(), EventViewActivity.class);
            intent.putExtra("Event", e);
            v.getContext().startActivity(intent);

        }
    }
}

