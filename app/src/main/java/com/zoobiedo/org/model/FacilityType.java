package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Venkatesh on 25-09-2016.
 */
public class FacilityType implements Parcelable {

    private String ground;
    private String practice;
    private String nets;
    private String organiser;
    private String date;

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getNets() {
        return nets;
    }

    public void setNets(String nets) {
        this.nets = nets;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ground);
        dest.writeString(this.practice);
        dest.writeString(this.nets);
        dest.writeString(this.organiser);
        dest.writeString(this.date);
    }

    public FacilityType() {
    }

    protected FacilityType(Parcel in) {
        this.ground = in.readString();
        this.practice = in.readString();
        this.nets = in.readString();
        this.organiser = in.readString();
        this.date = in.readString();
    }

    public static final Creator<FacilityType> CREATOR = new Creator<FacilityType>() {
        @Override
        public FacilityType createFromParcel(Parcel source) {
            return new FacilityType(source);
        }

        @Override
        public FacilityType[] newArray(int size) {
            return new FacilityType[size];
        }
    };
}
