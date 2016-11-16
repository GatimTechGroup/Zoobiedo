package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Venkatesh on 05-10-2016.
 */
public class FacilitySlotsRequestData implements Parcelable{

    private int CityID;
    private int SportsType;
    private String GPSCoordinates;
    private String SearchDate;


    public int getCityID() {
        return CityID;
    }

    public void setCityID(int cityID) {
        CityID = cityID;
    }

    public int getSportsType() {
        return SportsType;
    }

    public void setSportsType(int sportsType) {
        SportsType = sportsType;
    }

    public String getGPSCoordinates() {
        return GPSCoordinates;
    }

    public void setGPSCoordinates(String GPSCoordinates) {
        this.GPSCoordinates = GPSCoordinates;
    }

    public String getSearchDate() {
        return SearchDate;
    }

    public void setSearchDate(String searchDate) {
        SearchDate = searchDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.CityID);
        dest.writeInt(this.SportsType);
        dest.writeString(this.GPSCoordinates);
        dest.writeString(this.SearchDate);
    }

    public FacilitySlotsRequestData() {
    }

    protected FacilitySlotsRequestData(Parcel in) {
        this.CityID = in.readInt();
        this.SportsType = in.readInt();
        this.GPSCoordinates = in.readString();
        this.SearchDate = in.readString();
    }

    public static final Creator<FacilitySlotsRequestData> CREATOR = new Creator<FacilitySlotsRequestData>() {
        @Override
        public FacilitySlotsRequestData createFromParcel(Parcel source) {
            return new FacilitySlotsRequestData(source);
        }

        @Override
        public FacilitySlotsRequestData[] newArray(int size) {
            return new FacilitySlotsRequestData[size];
        }
    };
}
