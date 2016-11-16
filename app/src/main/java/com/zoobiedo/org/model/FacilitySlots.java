package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Venkatesh on 05-10-2016.
 */
public class FacilitySlots implements Parcelable{

    @SerializedName("Key")
    private String key;
    @SerializedName("Value")
    private ArrayList<Facilities> value;



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<Facilities> getValue() {
        return value;
    }

    public void setValue(ArrayList<Facilities> value) {
        this.value = value;
    }

    public FacilitySlots() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.key);
        dest.writeTypedList(this.value);
    }

    protected FacilitySlots(Parcel in) {
        this.key = in.readString();
        this.value = in.createTypedArrayList(Facilities.CREATOR);
    }

    public static final Creator<FacilitySlots> CREATOR = new Creator<FacilitySlots>() {
        @Override
        public FacilitySlots createFromParcel(Parcel source) {
            return new FacilitySlots(source);
        }

        @Override
        public FacilitySlots[] newArray(int size) {
            return new FacilitySlots[size];
        }
    };
}
