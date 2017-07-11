package com.lithub.team8.wheresmystuff.model;

/**
  * Created by Kirtan on 6/28/2017.
  */

public class Admin {

    private String name;
    private String password;
    private Integer id;

    /**
     * constructor for setting up an admin
     * @param id
     * @param name
     * @param password
     */
    public Admin(String name, String password, Integer id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }
    /**
     * setter for name
     * @param name  to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * setter for Password
     * @param password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * setter for id
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * getter for name
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * getter for id
     * @return the Id
     */
    public int getId() {
        return id;
    }
    /**
     * getter for password
     *  @return the password
     */
    public String getPassword() {
        return password;
    }
}
