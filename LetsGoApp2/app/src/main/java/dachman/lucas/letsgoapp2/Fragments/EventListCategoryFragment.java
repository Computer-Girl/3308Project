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

import dachman.lucas.letsgoapp2.EventGenerator;
import dachman.lucas.letsgoapp2.Models.Category;
import dachman.lucas.letsgoapp2.Models.Event;
import dachman.lucas.letsgoapp2.Adapters.EventListRecyclerAdapter;
import dachman.lucas.letsgoapp2.R;

public class EventListCategoryFragment extends Fragment {

    private static final String ARG_PARAM1 = Category.NAME;

    private Category category;
    private ArrayList<Event> events;
    private RecyclerView recyclerView;
    private EventListRecyclerAdapter adapter;

    public EventListCategoryFragment() {
        // Required empty public constructor
    }

    /**
     *
     * @param cat - The Category to filter
     * @return - A new instance of this Fragment
     */
    public static EventListCategoryFragment newInstance(Category cat) {
        EventListCategoryFragment fragment = new EventListCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, cat.name());
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * creates an instance of this fragment alon gwith
     * new array list and adds evetns to context
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = Category.valueOf(getArguments().getString(ARG_PARAM1));
        }

        // list of Events used to populate Recycler View
        events = new ArrayList<Event>();
        addEvents(events, category, getContext());

    }

    /**
     * Populates list with Event objects.
     *
     * @param list - the list to populate
     * @param category - Category to filter out
     * @param context
     */
    public static void addEvents(ArrayList<Event> list, Category category, Context context) {
        // Populate arraylist to be given to Recycler adapter:

        EventGenerator eg = EventGenerator.getInstance(context);
        ArrayList<Event> tempEvents = eg.getEvents();
        for(Event e : tempEvents) {
            if(e.getCategory() == category) {
                list.add(e);
            }
        }

    }

    /**
     * inflates views for activity
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
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
