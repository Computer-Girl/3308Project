package dachman.lucas.letsgoapp2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
        events = new ArrayList<Event>();
        events.add(new Event());
        events.add(new Event());

        recyclerView = (RecyclerView) findViewById(R.id.event_list2_RecyclerView);
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
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }


    class EventListViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView eventNameView;

        public EventListViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.event_list2_Image);
            eventNameView = (TextView) itemView.findViewById(R.id.event_list2_EventName);


        }
    }
}

