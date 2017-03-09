package dachman.lucas.letsgoapp2;

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


    public static Event [] events;

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


    public static Event [] getEvents() {
        events = new Event[eventInfo.length];

        for(int i = 0; i < events.length; i++) {
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
            events[i] = e;
        }

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
