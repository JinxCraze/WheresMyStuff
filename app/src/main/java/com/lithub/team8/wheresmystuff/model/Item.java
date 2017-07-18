package com.lithub.team8.wheresmystuff.model;

import com.google.android.gms.maps.model.LatLng;

/**
  * Created by Kirtan on 6/28/2017.
  */
public class Item {

    private String name;
    private String description;
    private String location;
    private String type;
    private double lat;
    private double lng;

    private Item item;

    public Item() {
        //needed for firebase database
    }

    /**
     * constructor
     *
     * @param name        name of Item
     * @param description description of Item
     * @param location    location of Item
     */
    public Item(String name, String description, String location, String type, double lat, double lng) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * getter for longitude
     *
     * @return longitude
     */
    public double getLng() {
        return lng;
    }

    /**
     * setter for id
     * @param lng sets longitude
     */
    public void setLng(double lng) { this.lng = lng; }


    /**
     * getter for Name
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for Name
     *
     * @param name name of Item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for Item Type
     *
     * @return itemType
     */
    public String getType() {
        return type;
    }

    /**
     * setter for type
     *
     * @param type sets type of item
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter for description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter for description
     *
     * @param description sets description to this one
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter for location
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * sets location
     *
     * @param location sets location to this
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter for Latitude
     *
     * @return lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * setter for Latitude
     *
     * @param lat sets lat to this
     */
    public void setLat(double lat) { this.lat = lat; }

    /**
     * toString
     *
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
}