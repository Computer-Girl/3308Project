package dachman.lucas.letsgoapp2.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by lucas on 2/19/17.
 * This is a Model Class for an Event Object.
 * Set the category field with a CATEGORY constant
 * This class implements Parcelable in order for it to be
 * passed between activities through an Intent.
 *
 * If you change this class, use the Android Studio Parcelable plugin to
 *      generate boilerplate Parcelable code. Alt+Insert -> Parcelable.
 *      This class will break if parcelable methods are not overrided
 *      correctly.
 */


/**
 * @version 1
 * class that creates events for app
 */
public class Event implements Parcelable{

    // Category Constants

    private String name;
    private String location;
    private String organizerName = "none";
    private Category category = Category.OTHER;
    private String description = "No Description";
    private int id;
    private Date date;
    private boolean isStarred;


    /**
     * @param _id
     * @param _name
     * @param _location
     * @param _date
     * creates info for each event
     */
    public Event(int _id, String _name, String _location, Date _date) {
        id = _id;
        name = _name;
        location = _location;
        date = _date;
    }

    /**
     * constructor for event class
     * @version 1
     */
    public Event() {
        id = -1;
        name = "Event Name";
        location = "Event Location";
        date = new Date(System.currentTimeMillis());

    }

    /***** Getters and Setters ****/

    /**
     *  getter for name
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for lcoation
     * @return string
     */
    public String getLocation() {
        return location;
    }

    /**
     * setter for location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter for ID
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * setter for ID for event
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for date
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * setter for date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * gets name
     * @return string
     */
    public String getOrganizerName() {
        return organizerName;
    }

    /**
     * sets name(s)
     * @param organizerName
     */
    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    /**
     * gets category
     * @return Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * sets categrory
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * gets description
     * @return string
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets description for event
     * @return string
     */
    public String getDescriptionShort() {
        String s;
        try {
            s = description.substring(0,50);
        } catch (IndexOutOfBoundsException e) {
            return description;
        }
        s += "...";
        return s;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStarred() {
        return isStarred;
    }

    public void setStarred(boolean starred) {
        this.isStarred = starred;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * write to string for parcel for event class
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeString(this.organizerName);
        dest.writeInt(this.category == null ? -1 : this.category.ordinal());
        dest.writeString(this.description);
        dest.writeInt(this.id);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeByte(this.isStarred ? (byte) 1 : (byte) 0);
    }

    /**
     * fills in even tinformation with matching event from db
     * @param in
     */
    protected Event(Parcel in) {
        this.name = in.readString();
        this.location = in.readString();
        this.organizerName = in.readString();
        int tmpCategory = in.readInt();
        this.category = tmpCategory == -1 ? null : Category.values()[tmpCategory];
        this.description = in.readString();
        this.id = in.readInt();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.isStarred = in.readByte() != 0;
    }

    /**
     * @version 1
     * creates event to inflate views for app
     */
    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
