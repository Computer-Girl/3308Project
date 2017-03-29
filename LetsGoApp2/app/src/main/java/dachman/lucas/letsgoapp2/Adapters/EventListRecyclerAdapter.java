package dachman.lucas.letsgoapp2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dachman.lucas.letsgoapp2.Models.Event;
import dachman.lucas.letsgoapp2.EventViewActivity;
import dachman.lucas.letsgoapp2.R;

/**
 * Created by lucas on 3/8/17.
 */

public class EventListRecyclerAdapter extends RecyclerView.Adapter<EventListRecyclerAdapter.EventListViewHolder> {

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
        holder.eventDescriptionView.setText(currentEvent.getDescriptionShort());
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
        TextView eventDescriptionView;

        public EventListViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.event_list_row_Image);
            eventNameView = (TextView) itemView.findViewById(R.id.event_list_row_EventName);
            eventDescriptionView = (TextView) itemView.findViewById(R.id.event_list_row_EventDescription);
            //set onClick listener to view more event info
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

