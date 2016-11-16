package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Venkatesh on 05-10-2016.
 */
public class FacilityBookings implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public FacilityBookings() {
    }

    protected FacilityBookings(Parcel in) {
    }

    public static final Creator<FacilityBookings> CREATOR = new Creator<FacilityBookings>() {
        @Override
        public FacilityBookings createFromParcel(Parcel source) {
            return new FacilityBookings(source);
        }

        @Override
        public FacilityBookings[] newArray(int size) {
            return new FacilityBookings[size];
        }
    };
}
