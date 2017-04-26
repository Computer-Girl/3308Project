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

    // ID, Name, Location, OrganizerName, Category, Description, starred
    public static String [] eventInfo = {
            "Career Fair, UMC, Lucas, CAREER, Find a Career, 1",
            "Some Event, UMC, Lucas, PUBLIC_SPEAKERS, Lucas will speak, 1",
            "Cool Event, Folsom Field, Bob, CULTURAL, This event will be fantastic, 0",
            "Meditation Session, Norlin Library, Allen, OTHER, A safe place to meditate, 0",
            "Jazz Ensemble lll & Thompson Latin Jazz Ensemble, Imig Music, CU Presents, ARTISTIC, Glen Miller: \"Here We Go Again\", 0",
            "Some Sorority Event, UMC, Chelsea, GREEK, gonna help people and stuff, 0",
            "Cultural Event, C4C, Jeff, CULTURAL, Help people learn about cool culture, 0",
            "Other Event, C4C, Jeff, OTHER, Help people learn about cool culture, 0"
    };

    private EventGenerator() {
        events = new ArrayList<Event>();
        parseEvents();
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

    public void parseEvents() {

        for(int i = 0; i < eventInfo.length; i++) {
            String eString = eventInfo[i];
            String [] eArray = eString.split(", ");
            Event e = new Event();
            e.setId(i);
            e.setName(eArray[0]);
            e.setLocation(eArray[1]);
            e.setOrganizerName(eArray[2]);
            e.setCategory(Category.valueOf(eArray[3]));
            e.setDescription(eArray[4]);
            e.setDate(randomDate());
            e.setStarred( (eArray[5].trim().equals("1")) ? true : false);
            events.add(e);
        }
    }

}
