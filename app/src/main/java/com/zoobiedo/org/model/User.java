package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Venkatesh on 22-09-2016.
 */
public class User implements Parcelable{

    private String name;
    private String profURL;
    private String email;
    private String dob;
    private String gender;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfURL() {
        return profURL;
    }

    public void setProfURL(String profURL) {
        this.profURL = profURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.profURL);
        dest.writeString(this.email);
        dest.writeString(this.dob);
        dest.writeString(this.gender);
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.profURL = in.readString();
        this.email = in.readString();
        this.dob = in.readString();
        this.gender = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
