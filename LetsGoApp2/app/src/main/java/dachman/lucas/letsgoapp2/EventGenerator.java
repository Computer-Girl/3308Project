package dachman.lucas.letsgoapp2;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import dachman.lucas.letsgoapp2.Models.Category;
import dachman.lucas.letsgoapp2.Models.Event;

/**
 * Created by lucas on 3/8/17.
 * Badly written event generator class for testing
 */

public class EventGenerator {


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

    private EventGenerator() {

    }

    public static EventGenerator getInstance(Context context) {
        if(eventGenerator == null) {
            eventGenerator = new EventGenerator();
        }
        return eventGenerator;
    }

    public ArrayList<Event> getEvents() {
        // TODO: Populate arraylist here
        return events;
    }

    public static Date randomDate() {

        long x = 1483236400L;
        long y = 1514772400L;
        Random r = new Random();
        long number = x+((long)(r.nextDouble()*(y-x)));
        return new Date(number);
    }

}
