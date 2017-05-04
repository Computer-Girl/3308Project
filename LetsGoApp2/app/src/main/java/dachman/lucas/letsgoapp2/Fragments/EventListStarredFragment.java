package dachman.lucas.letsgoapp2.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dachman.lucas.letsgoapp2.Adapters.EventListRecyclerAdapter;
import dachman.lucas.letsgoapp2.EventGenerator;
import dachman.lucas.letsgoapp2.Models.Category;
import dachman.lucas.letsgoapp2.Models.Event;
import dachman.lucas.letsgoapp2.R;

/**
 * Created by Lucas Dachman
 *
 * This class is a Fragment class used to display events labelled as "starred"
 * It is almost exactly the same as EventListSCategoryFragment but it displays
 * starred events instead of events in a category.
 */



public class EventListStarredFragment extends Fragment {

    private static final String ARG_PARAM1 = Category.NAME;

    private ArrayList<Event> events;
    private RecyclerView recyclerView;
    private EventListRecyclerAdapter adapter;

    /**
     * Required empty public constructor
     * @version 1
     */
    public EventListStarredFragment() {
        // Required empty public constructor
    }
    
    /**
     * creates new instance for starred fragment
     * @return fragment
     */

    public static EventListStarredFragment newInstance() {
        EventListStarredFragment fragment = new EventListStarredFragment();
        return fragment;
    }
    
    /**
     * creates new array list and adds events to context
     * @param savedInstanceState
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // list of Events used to populate Recycler View
        events = new ArrayList<Event>();
        addEvents(events, getContext());

    }


    public static void addEvents(ArrayList<Event> list, Context context) {
        // Populate arraylist to be given to Recycler adapter:
        EventGenerator eg = EventGenerator.getInstance(context);
        ArrayList<Event> tempEvents = eg.getEvents();
        for(Event e : tempEvents) {
            if(e.isStarred()) {
                Log.d("Starred:", e.getName());
                list.add(e);
            }
        }
    }

    /**
     * inflates views for starred category of events
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_event_list_all, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.event_list_fragment_RecyclerView);
        adapter = new EventListRecyclerAdapter(v.getContext(), events);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        return v;
    }
}
