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

public class Event implements Parcelable{

    // Category Constants

    private String name;
    private String location;
    private String organizerName = "none";
    private Category category = Category.OTHER;
    private String description = "No Description";
    private int id;
    private Date date;
    private boolean showAsStarred;


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

    /***** Getters and Setters ****/

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

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isShowAsStarred() {
        return showAsStarred;
    }

    public void setShowAsStarred(boolean showAsStarred) {
        this.showAsStarred = showAsStarred;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeString(this.organizerName);
        dest.writeInt(this.category == null ? -1 : this.category.ordinal());
        dest.writeString(this.description);
        dest.writeInt(this.id);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeByte(this.showAsStarred ? (byte) 1 : (byte) 0);
    }

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
        this.showAsStarred = in.readByte() != 0;
    }

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
