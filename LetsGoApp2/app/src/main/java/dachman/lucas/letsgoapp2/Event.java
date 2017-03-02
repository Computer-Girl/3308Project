package dachman.lucas.letsgoapp2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by lucas on 2/19/17.
 */

public class Event implements Parcelable{

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

    protected Event(Parcel in) {
        name = in.readString();
        location = in.readString();
        id = in.readInt();
        date = new Date(in.readLong());
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeInt(id);
        dest.writeLong(date.getTime());
    }
}
