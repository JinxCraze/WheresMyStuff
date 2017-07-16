package com.lithub.team8.wheresmystuff.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
  * Created by Kirtan on 6/28/2017.
  */
public class Item implements Parcelable {

    private String name;
    private String description;
    private String location;
    private String type;

    private LatLng locationLL;
    private static long id = 0;


    public Item() {

    }
    /**
     * constructor
     * @param name name of Item
     * @param description description of Item
     * @param location location of Item
     */
    public Item(String name, String description, String location, String type, LatLng locationLL) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
        this.locationLL = locationLL;
        id = id++;
    }

    /**
     * getter for ID
     * @return Id
     */
    public long getId() {
        return id;
    }

    /**
     * getter for Name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for Name
     * @param name name of Item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for Item Type
     * @return itemType
     */
    public String getType() {
        return type;
    }

    /**
     * setter for type
     * @param type sets type of item
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter for description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter for description
     * @param description sets description to this one
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter for location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * sets location
     * @param location sets location to this
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter for Latitude and Longitude
     * @return lat and long
     */
    public LatLng getLocationLL() {
        return locationLL;
    }

    /**
     * setter for Latitude and Longitude
     * @param locationLL sets lat and long to this
     */
    public void setLocationLL(LatLng locationLL) {
        this.locationLL = locationLL;
    }

    /**
     * toString
     * @return tostring of Item
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
     * @param in whatever is passed in
     */
    private Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        location = in.readString();
    }

    /**
     * describe contents
     * @return 0
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
