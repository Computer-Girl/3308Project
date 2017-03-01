package dachman.lucas.letsgoapp2;

import java.util.Date;

/**
 * Created by lucas on 2/19/17.
 */

public class Event {

    private String name, location;
    private int id;
    private Date date;

    public Event(int _id, String _name, String _location, Date _date) {
        id = _id;
        name = _name;
        location = _location;
        date = _date;
    }

    public Event() {
        id = -1;
        name = "Event Name";
        location = "Event Location";
        date = new Date(System.currentTimeMillis());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
