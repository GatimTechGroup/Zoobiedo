package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Venkatesh on 04-10-2016.
 */
public class Facilities  implements Parcelable{

     private int FacilityId;
     private String FacilityName;
     private int FacilityOwnerId;
     private int FacilityTypeId;
     private String Image1URL;
     private String Image2URL;
     private String Image3URL;
     private String Image4URL;
     private String Image5URL;
     private boolean IsBookingAllowed;
     private boolean IsSameAddress;
     private boolean IsVerified;
     private int ListingEntityId;
     private int SportsTypeId;
     private String VideoURL;
     private int facilitytype;
     private int sportstype;
     private ArrayList<SubFacilities> subfacilities;


    public int getFacilityId() {
        return FacilityId;
    }

    public void setFacilityId(int facilityId) {
        FacilityId = facilityId;
    }

    public String getFacilityName() {
        return FacilityName;
    }

    public void setFacilityName(String facilityName) {
        FacilityName = facilityName;
    }

    public int getFacilityOwnerId() {
        return FacilityOwnerId;
    }

    public void setFacilityOwnerId(int facilityOwnerId) {
        FacilityOwnerId = facilityOwnerId;
    }

    public int getFacilityTypeId() {
        return FacilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        FacilityTypeId = facilityTypeId;
    }

    public String getImage1URL() {
        return Image1URL;
    }

    public void setImage1URL(String image1URL) {
        Image1URL = image1URL;
    }

    public String getImage2URL() {
        return Image2URL;
    }

    public void setImage2URL(String image2URL) {
        Image2URL = image2URL;
    }

    public String getImage3URL() {
        return Image3URL;
    }

    public void setImage3URL(String image3URL) {
        Image3URL = image3URL;
    }

    public String getImage4URL() {
        return Image4URL;
    }

    public void setImage4URL(String image4URL) {
        Image4URL = image4URL;
    }

    public String getImage5URL() {
        return Image5URL;
    }

    public void setImage5URL(String image5URL) {
        Image5URL = image5URL;
    }

    public boolean isBookingAllowed() {
        return IsBookingAllowed;
    }

    public void setIsBookingAllowed(boolean isBookingAllowed) {
        IsBookingAllowed = isBookingAllowed;
    }

    public boolean isSameAddress() {
        return IsSameAddress;
    }

    public void setIsSameAddress(boolean isSameAddress) {
        IsSameAddress = isSameAddress;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setIsVerified(boolean isVerified) {
        IsVerified = isVerified;
    }

    public int getListingEntityId() {
        return ListingEntityId;
    }

    public void setListingEntityId(int listingEntityId) {
        ListingEntityId = listingEntityId;
    }

    public int getSportsTypeId() {
        return SportsTypeId;
    }

    public void setSportsTypeId(int sportsTypeId) {
        SportsTypeId = sportsTypeId;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }

    public int getFacilitytype() {
        return facilitytype;
    }

    public void setFacilitytype(int facilitytype) {
        this.facilitytype = facilitytype;
    }

    public int getSportstype() {
        return sportstype;
    }

    public void setSportstype(int sportstype) {
        this.sportstype = sportstype;
    }

    public ArrayList<SubFacilities> getSubfacilities() {
        return subfacilities;
    }

    public void setSubfacilities(ArrayList<SubFacilities> subfacilities) {
        this.subfacilities = subfacilities;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.FacilityId);
        dest.writeString(this.FacilityName);
        dest.writeInt(this.FacilityOwnerId);
        dest.writeInt(this.FacilityTypeId);
        dest.writeString(this.Image1URL);
        dest.writeString(this.Image2URL);
        dest.writeString(this.Image3URL);
        dest.writeString(this.Image4URL);
        dest.writeString(this.Image5URL);
        dest.writeByte(this.IsBookingAllowed ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsSameAddress ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsVerified ? (byte) 1 : (byte) 0);
        dest.writeInt(this.ListingEntityId);
        dest.writeInt(this.SportsTypeId);
        dest.writeString(this.VideoURL);
        dest.writeInt(this.facilitytype);
        dest.writeInt(this.sportstype);
        dest.writeTypedList(this.subfacilities);
    }

    public Facilities() {
    }

    protected Facilities(Parcel in) {
        this.FacilityId = in.readInt();
        this.FacilityName = in.readString();
        this.FacilityOwnerId = in.readInt();
        this.FacilityTypeId = in.readInt();
        this.Image1URL = in.readString();
        this.Image2URL = in.readString();
        this.Image3URL = in.readString();
        this.Image4URL = in.readString();
        this.Image5URL = in.readString();
        this.IsBookingAllowed = in.readByte() != 0;
        this.IsSameAddress = in.readByte() != 0;
        this.IsVerified = in.readByte() != 0;
        this.ListingEntityId = in.readInt();
        this.SportsTypeId = in.readInt();
        this.VideoURL = in.readString();
        this.facilitytype = in.readInt();
        this.sportstype = in.readInt();
        this.subfacilities = in.createTypedArrayList(SubFacilities.CREATOR);
    }

    public static final Creator<Facilities> CREATOR = new Creator<Facilities>() {
        @Override
        public Facilities createFromParcel(Parcel source) {
            return new Facilities(source);
        }

        @Override
        public Facilities[] newArray(int size) {
            return new Facilities[size];
        }
    };
}
