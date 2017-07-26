package com.lithub.team8.wheresmystuff.model;

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
     * getter for description
     *
     * @return description
     */
    public String getDescription() {
        return description;
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
     * getter for Latitude
     *
     * @return lat
     */
    public double getLat() {
        return lat;
    }

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