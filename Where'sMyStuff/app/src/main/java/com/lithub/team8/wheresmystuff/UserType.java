package com.lithub.team8.wheresmystuff;

/**
 * Created by eric on 6/21/17.
 */

public enum UserType {
    USER("user"), ADMIN("admin");

    private final String type;

    /**
     * Constructor for the enumeration
     * @param ptype
     */
    UserType(String ptype) {
        this.type = ptype;
    }

    /**
     * Returns the user type into string
     * @return the type in string
     */
    public String toString() {
        return type;
    }

}