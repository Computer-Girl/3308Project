package dachman.lucas.letsgoapp2;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import dachman.lucas.letsgoapp2.Models.Category;
import dachman.lucas.letsgoapp2.Models.Event;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lucas on 3/8/17.
 * Badly written event generator class for testing
 * this is where the events get fetched from database
 */

public class EventGenerator {

    private ProgressDialog pDialog;
    private ListView lv;

    private static String url = "http://letsgoapp2.herokuapp.com";

    ArrayList<HashMap<String, String>> eventList;

    private SQLiteDatabase database;
    private CreateDatabase dbHelper;
    private String[] allColumns = {
            CreateDatabase.COLUMN_ID,
            CreateDatabase.COLUMN_NAME,
            CreateDatabase.COLUMN_ORGANIZER,
            CreateDatabase.COLUMN_CATEGORY,
            CreateDatabase.COLUMN_DESCRIPTION,
            CreateDatabase.COLUMN_DATE,
            CreateDatabase.COLUMN_LOCATION
            //CreateDatabase.COLUMN_STAR
    };

    public ArrayList<Event> events;
    public static EventGenerator eventGenerator;

    // ID, Name, Location, OrganizerName, Category, Description, Date
    public static String [] eventInfo = {
            "Career Fair, UMC, Lucas, CAREER, Find a Career",
            "Some Event, UMC, Lucas, PUBLIC_SPEAKERS, Lucas will speak",
            "Cool Event, Folsom Field, Bob, CULTURAL, This event will be fantastic",
            "Meditation Session, Norlin Library, Allen, OTHER, A safe place to meditate",
            "Jazz Ensemble lll & Thompson Latin Jazz Ensemble, Imig Music, CU Presents, ARTISTIC, Glen Miller: \"Here We Go Again\"",
            "Some Sorority Event, UMC, Chelsea, GREEK, gonna help people and stuff",
            "Cultural Event, C4C, Jeff, CULTURAL, Help people learn about cool culture",
            "Other Event, C4C, Jeff, OTHER, Help people learn about cool culture"
    };

    /**
     *
     * @param context
     * creates Database and new array list of events
     */
    public EventGenerator(Context context) {
        Log.d("EventGenerator2","test");
        dbHelper = new CreateDatabase(context);
        new GetEvents().execute();
        events = new ArrayList<Event>();

        //Event temp = createEvent(eventInfo[1].split(", "));
        //deleteEvent(temp);
        //temp = createEvent(eventInfo[0].split(", "));
        open();
        Cursor cursor = database.query(CreateDatabase.TABLE_EVENTS,
                allColumns, null, null, null, null, null);
        if (cursor == null)
            return;

        cursor.moveToFirst();
        //List<String> temp = new ArrayList<String>();
        //temp.add("TEST");
        while (!cursor.isAfterLast()) {
            //if (temp.contains(event.getName()) == false) {
            Event event = cursorToEvent(cursor);
            events.add(event);
            cursor.moveToNext();
            //temp.add(event.getName());
            //}
        }
        // make sure to close the cursor
        cursor.close();
        close();
    }

    /**
     *
     * @throws SQLException
     * gets writable database
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
    //DO NOT USE YET
    /**
     *
     * @param Data
     * @return Event
     * puts values for event into database upon login
     */
    public Event createEvent(String [] Data) {
        open();
        ContentValues values = new ContentValues();
        values.put(CreateDatabase.COLUMN_NAME, Data[0]);
        values.put(CreateDatabase.COLUMN_ORGANIZER, Data[2]);
        values.put(CreateDatabase.COLUMN_CATEGORY, Data[3]);
        values.put(CreateDatabase.COLUMN_DESCRIPTION, Data[4]);
        values.put(CreateDatabase.COLUMN_DATE, "1/2/3");
        values.put(CreateDatabase.COLUMN_LOCATION, Data[1]);

        long insertId = database.insert(CreateDatabase.TABLE_EVENTS, null,
                values);

        Event newEvent = new Event();
        close();
        return newEvent;
    }
    /**
     *
     * @param event
     * used to delete event if necessary
     */
    public void deleteEvent(Event event) {
        long id = event.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(CreateDatabase.TABLE_EVENTS, CreateDatabase.COLUMN_ID
                + " = " + id, null);
    }

    /**
     *
     * @param context
     * @return eventGenerator
     */
    public static EventGenerator getInstance(Context context) {
        if(eventGenerator == null) {
            eventGenerator = new EventGenerator(context);
        }
        return eventGenerator;
    }

    /**
     *
     * @return event
     * goes through and fethces all events for eventview activity
     */
    public ArrayList<Event> getEvents() {


        return events;
    }

    /**
    * @param cursor
    * @return Event
    * used to access events from database to set information about
    * event for textview for user
    */
    private Event cursorToEvent(Cursor cursor) {
        Event event = new Event();
        event.setId(cursor.getInt(0));
        event.setName(cursor.getString(1));
        event.setCategory(Category.valueOf(cursor.getString(3)));
        event.setDate(randomDate());
        event.setDescription(cursor.getString(4));
        event.setOrganizerName(cursor.getString(2));
        event.setStarred(false);
        return event;
    }


    /**
     * random date generator not used for final product
     * @return static date
     */
    public static Date randomDate() {

        long x = 1483236400L;
        long y = 1514772400L;
        Random r = new Random();
        long number = x+((long)(r.nextDouble()*(y-x)));
        return new Date(number);
    }

    private class GetEvents extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            /*pDialog = new ProgressDialog(EventGenerator.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();*/

        }

        @Override
        public  Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.d("EventGenerator1","TEST");
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray events = jsonObj.getJSONArray("events");

                    // looping through All Contacts
                    for (int i = 0; i < events.length(); i++) {
                        JSONObject c = events.getJSONObject(i);

                        String category = c.getString("category");
                        String date = c.getString("date");
                        String description = c.getString("description");
                        String id = c.getString("id");
                        String location = c.getString("location");
                        String name = c.getString("name");
                        String organizer = c.getString("organizer");
                        String star = c.getString("star");
                        String event[] = {name,location,organizer,category,description};
                        Log.d("TEST","TEST");
                        Event temp = createEvent(event);
                    }


                } catch (final JSONException e) {
                }

                return null;
            }

            return null;
        }

    }
}
