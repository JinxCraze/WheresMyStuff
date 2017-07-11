package com.lithub.team8.wheresmystuff.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
  * Created by Kirtan on 6/28/2017.
  */
public class Item implements Parcelable {

    private String name;
    private String description;
    private String location;
    private String type;
    private static long id = 0;

    /**
     * constructor
     * @param name
     * @param description
     * @param location
     */
    public Item(String name, String description, String location, String type) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
        id = id++;
    }


    public long getId() {
        return id;
    }

    /**
     * getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * setter
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter for location
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * sets location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return name + "\n" + description + "\n" + location;
    }

    /* *********************************
     * These methods are required by the parcelable interface
     *
     */

    /**
     *  constructor
     * @param in
     */
    private Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        location = in.readString();
    }

    /**
     * describe contents
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /* *************************
       If you add new instance vars to Student, you will need to add them
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(location);
    }

    /**
     *  to make parseable
     */
    public static final Parcelable.Creator<Item> CREATOR
            = new Parcelable.Creator<Item>() {
                public Item createFromParcel(Parcel in) {
                    return new Item(in);
                }

                public Item[] newArray(int size) {
                    return new Item[size];
                }
            };
}
