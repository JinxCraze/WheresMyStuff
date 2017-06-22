package com.lithub.team8.wheresmystuff;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class User implements Parcelable {

    public static List<UserType> legalUserTypes = Arrays.asList(UserType.USER, UserType.ADMIN);
    private static int Next_Id = 0;

    private int _id;
    private String _name;
    private UserType _usertype;

    /* **********************
     * Getters and setters
     */
    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    //no setter for this.  id is a read only field
    public int getId() { return _id; }

    public UserType getUserType() {return _usertype; }
    public void setUserType(UserType userType) { _usertype = userType; }

    public static int findPosition(String code) {
        int i = 0;
        while (i < legalUserTypes.size()) {
            if (code.equals(legalUserTypes.get(i))) return i;
            ++i;
        }
        return 0;
    }

    /**
     * Make a new user
     * @param name the user's name
     * @param userType the user's type
     */
    public User(String name, UserType userType) {
        _name = name;
        _usertype = userType;
        _id = User.Next_Id++;
    }

    /**
     * Make a new user
     * @param name      the User's name
     */
    public User(String name) {
        this(name, UserType.USER);
    }


    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new User dialog
     */
    public User() {
        this("enter new name" , UserType.USER);
    }

    /**
     * Returns string
     * @return the display string representation
     */
    @Override
    public String toString() {
        return _name + " " + _usertype;
    }


    /* *********************************
     * These methods are required by the parcelable interface
     *
     */

    private User(Parcel in) {
        _name = in.readString();
        _usertype = (UserType) in.readSerializable();
        _id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /* *************************
       If you add new instance vars to User, you will need to add them to the write
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(_name);
         dest.writeSerializable(_usertype);
         dest.writeInt(_id);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
