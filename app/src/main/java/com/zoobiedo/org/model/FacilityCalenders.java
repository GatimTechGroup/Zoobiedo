package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Venkatesh on 01-10-2016.
 */
public class FacilityCalenders implements Parcelable{

    private String BookingDate;
    private int FacilityCalendarId;
    private int FullDayFacilityBookingId;
    private int FullDayPrice;
    private int SubFacilityId;
    private ArrayList<BookingTimeSlots> bookingtimeslots;
    private int facilitybooking;


    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public int getFacilityCalendarId() {
        return FacilityCalendarId;
    }

    public void setFacilityCalendarId(int facilityCalendarId) {
        FacilityCalendarId = facilityCalendarId;
    }

    public int getFullDayFacilityBookingId() {
        return FullDayFacilityBookingId;
    }

    public void setFullDayFacilityBookingId(int fullDayFacilityBookingId) {
        FullDayFacilityBookingId = fullDayFacilityBookingId;
    }

    public int getFullDayPrice() {
        return FullDayPrice;
    }

    public void setFullDayPrice(int fullDayPrice) {
        FullDayPrice = fullDayPrice;
    }

    public int getSubFacilityId() {
        return SubFacilityId;
    }

    public void setSubFacilityId(int subFacilityId) {
        SubFacilityId = subFacilityId;
    }

    public ArrayList<BookingTimeSlots> getBookingtimeslots() {
        return bookingtimeslots;
    }

    public void setBookingtimeslots(ArrayList<BookingTimeSlots> bookingtimeslots) {
        this.bookingtimeslots = bookingtimeslots;
    }

    public int getFacilitybooking() {
        return facilitybooking;
    }

    public void setFacilitybooking(int facilitybooking) {
        this.facilitybooking = facilitybooking;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.BookingDate);
        dest.writeInt(this.FacilityCalendarId);
        dest.writeInt(this.FullDayFacilityBookingId);
        dest.writeInt(this.FullDayPrice);
        dest.writeInt(this.SubFacilityId);
        dest.writeTypedList(this.bookingtimeslots);
        dest.writeInt(this.facilitybooking);
    }

    public FacilityCalenders() {
    }

    protected FacilityCalenders(Parcel in) {
        this.BookingDate = in.readString();
        this.FacilityCalendarId = in.readInt();
        this.FullDayFacilityBookingId = in.readInt();
        this.FullDayPrice = in.readInt();
        this.SubFacilityId = in.readInt();
        this.bookingtimeslots = in.createTypedArrayList(BookingTimeSlots.CREATOR);
        this.facilitybooking = in.readInt();
    }

    public static final Creator<FacilityCalenders> CREATOR = new Creator<FacilityCalenders>() {
        @Override
        public FacilityCalenders createFromParcel(Parcel source) {
            return new FacilityCalenders(source);
        }

        @Override
        public FacilityCalenders[] newArray(int size) {
            return new FacilityCalenders[size];
        }
    };
}
