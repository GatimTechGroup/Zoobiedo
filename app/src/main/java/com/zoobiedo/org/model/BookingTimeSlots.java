package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Venkatesh on 05-10-2016.
 */
public class BookingTimeSlots implements Parcelable{

    private int BookingTimeSlotId;
    private String EndTime;
    private int FacilityBookingId1;
    private int FacilityBookingId2;
    private int FacilityCalendarId;
    private int SingleTeamPrice;
    private int SlotPrice;
    private String StartTime;
    private int facilitybooking;
    private int facilitybooking1;


    public int getBookingTimeSlotId() {
        return BookingTimeSlotId;
    }

    public void setBookingTimeSlotId(int bookingTimeSlotId) {
        BookingTimeSlotId = bookingTimeSlotId;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public int getFacilityBookingId1() {
        return FacilityBookingId1;
    }

    public void setFacilityBookingId1(int facilityBookingId1) {
        FacilityBookingId1 = facilityBookingId1;
    }

    public int getFacilityBookingId2() {
        return FacilityBookingId2;
    }

    public void setFacilityBookingId2(int facilityBookingId2) {
        FacilityBookingId2 = facilityBookingId2;
    }

    public int getFacilityCalendarId() {
        return FacilityCalendarId;
    }

    public void setFacilityCalendarId(int facilityCalendarId) {
        FacilityCalendarId = facilityCalendarId;
    }

    public int getSingleTeamPrice() {
        return SingleTeamPrice;
    }

    public void setSingleTeamPrice(int singleTeamPrice) {
        SingleTeamPrice = singleTeamPrice;
    }

    public int getSlotPrice() {
        return SlotPrice;
    }

    public void setSlotPrice(int slotPrice) {
        SlotPrice = slotPrice;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public int getFacilitybooking() {
        return facilitybooking;
    }

    public void setFacilitybooking(int facilitybooking) {
        this.facilitybooking = facilitybooking;
    }

    public int getFacilitybooking1() {
        return facilitybooking1;
    }

    public void setFacilitybooking1(int facilitybooking1) {
        this.facilitybooking1 = facilitybooking1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.BookingTimeSlotId);
        dest.writeString(this.EndTime);
        dest.writeInt(this.FacilityBookingId1);
        dest.writeInt(this.FacilityBookingId2);
        dest.writeInt(this.FacilityCalendarId);
        dest.writeInt(this.SingleTeamPrice);
        dest.writeInt(this.SlotPrice);
        dest.writeString(this.StartTime);
        dest.writeInt(this.facilitybooking);
        dest.writeInt(this.facilitybooking1);
    }

    public BookingTimeSlots() {
    }

    protected BookingTimeSlots(Parcel in) {
        this.BookingTimeSlotId = in.readInt();
        this.EndTime = in.readString();
        this.FacilityBookingId1 = in.readInt();
        this.FacilityBookingId2 = in.readInt();
        this.FacilityCalendarId = in.readInt();
        this.SingleTeamPrice = in.readInt();
        this.SlotPrice = in.readInt();
        this.StartTime = in.readString();
        this.facilitybooking = in.readInt();
        this.facilitybooking1 = in.readInt();
    }

    public static final Creator<BookingTimeSlots> CREATOR = new Creator<BookingTimeSlots>() {
        @Override
        public BookingTimeSlots createFromParcel(Parcel source) {
            return new BookingTimeSlots(source);
        }

        @Override
        public BookingTimeSlots[] newArray(int size) {
            return new BookingTimeSlots[size];
        }
    };
}
