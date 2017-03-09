package dachman.lucas.letsgoapp2.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import dachman.lucas.letsgoapp2.Models.Category;
import dachman.lucas.letsgoapp2.Models.Event;
import dachman.lucas.letsgoapp2.Adapters.EventListRecyclerAdapter;
import dachman.lucas.letsgoapp2.R;

public class EventListAllFragment extends Fragment {

    private static final String ARG_PARAM1 = Category.NAME;

    private Category category;
    private ArrayList<Event> events;
    private RecyclerView recyclerView;
    private EventListRecyclerAdapter adapter;

    public EventListAllFragment() {
        // Required empty public constructor
    }

    public static EventListAllFragment newInstance(Category cat) {
        EventListAllFragment fragment = new EventListAllFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, cat.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = Category.valueOf(getArguments().getString(ARG_PARAM1));
        }

        // list of Events used to populate Recycler View
        events = new ArrayList<Event>();
        addEvents(events);

    }

    // Add Arbitrary events for testing
    public static void addEvents(ArrayList<Event> list) {
        // TODO: delete this
        // Arbitrary Event objects for demo:
        final int MILLIS_IN_DAY = 86400000;
        for(int i=0; i < 20; i++) {
            Event e = new Event(i, "Event "+i, "UMC", new Date(System.currentTimeMillis()+i*MILLIS_IN_DAY));
            list.add(e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_event_list_all, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.event_list_RecyclerView);
        adapter = new EventListRecyclerAdapter(v.getContext(), events);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        return v;
    }
}
