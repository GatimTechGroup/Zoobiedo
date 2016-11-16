package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Venkatesh on 04-10-2016.
 */
public class SubFacilities implements Parcelable{

    private String AddressLine1;
    private String AddressLine2;
    private String AddressLine3;
    private String City;
    private int CityId;
    private float Distance;
    private int FacilityId;
    private int FlooringTypeId;
    private String GPSCoordinates;
    private int GroundTypeId;
    private boolean HasAmbulance;
    private boolean HasBallPurchase;
    private boolean HasCafeteria;
    private boolean HasFirstAid;
    private boolean HasFloodLight;
    private boolean HasRestRoom;
    private boolean HasShoeRental;
    private boolean HasShower;
    private String Image1URL;
    private String Image2URL;
    private String Image3URL;
    private String Image4URL;
    private String Image5URL;
    private boolean IsBookingAllowed;
    private boolean IsDefaultSubFacility;
    private boolean IsIndoor;
    private String Landline;
    private String Mobile;
    private String Pincode;
    private int PitchTypeId;
    private String State;
    private int SubFacilityId;
    private String SubFacilityName;
    private int SubFacilityTypeId;
    private String VideoURL;
    private ArrayList<FacilityBookings> facilitybookings;
    private ArrayList<FacilityCalenders> facilitycalendars;
    private int flooringtype;
    private int groundtype;
    private int pitchtype;
    private int pricingrule;
    private int subfacilitytype;



    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return AddressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        AddressLine3 = addressLine3;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public float getDistance() {
        return Distance;
    }

    public void setDistance(float distance) {
        Distance = distance;
    }

    public int getFacilityId() {
        return FacilityId;
    }

    public void setFacilityId(int facilityId) {
        FacilityId = facilityId;
    }

    public int getFlooringTypeId() {
        return FlooringTypeId;
    }

    public void setFlooringTypeId(int flooringTypeId) {
        FlooringTypeId = flooringTypeId;
    }

    public String getGPSCoordinates() {
        return GPSCoordinates;
    }

    public void setGPSCoordinates(String GPSCoordinates) {
        this.GPSCoordinates = GPSCoordinates;
    }

    public int getGroundTypeId() {
        return GroundTypeId;
    }

    public void setGroundTypeId(int groundTypeId) {
        GroundTypeId = groundTypeId;
    }

    public boolean isHasAmbulance() {
        return HasAmbulance;
    }

    public void setHasAmbulance(boolean hasAmbulance) {
        HasAmbulance = hasAmbulance;
    }

    public boolean isHasBallPurchase() {
        return HasBallPurchase;
    }

    public void setHasBallPurchase(boolean hasBallPurchase) {
        HasBallPurchase = hasBallPurchase;
    }

    public boolean isHasCafeteria() {
        return HasCafeteria;
    }

    public void setHasCafeteria(boolean hasCafeteria) {
        HasCafeteria = hasCafeteria;
    }

    public boolean isHasFirstAid() {
        return HasFirstAid;
    }

    public void setHasFirstAid(boolean hasFirstAid) {
        HasFirstAid = hasFirstAid;
    }

    public boolean isHasFloodLight() {
        return HasFloodLight;
    }

    public void setHasFloodLight(boolean hasFloodLight) {
        HasFloodLight = hasFloodLight;
    }

    public boolean isHasRestRoom() {
        return HasRestRoom;
    }

    public void setHasRestRoom(boolean hasRestRoom) {
        HasRestRoom = hasRestRoom;
    }

    public boolean isHasShoeRental() {
        return HasShoeRental;
    }

    public void setHasShoeRental(boolean hasShoeRental) {
        HasShoeRental = hasShoeRental;
    }

    public boolean isHasShower() {
        return HasShower;
    }

    public void setHasShower(boolean hasShower) {
        HasShower = hasShower;
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

    public boolean isDefaultSubFacility() {
        return IsDefaultSubFacility;
    }

    public void setIsDefaultSubFacility(boolean isDefaultSubFacility) {
        IsDefaultSubFacility = isDefaultSubFacility;
    }

    public boolean isIndoor() {
        return IsIndoor;
    }

    public void setIsIndoor(boolean isIndoor) {
        IsIndoor = isIndoor;
    }

    public String getLandline() {
        return Landline;
    }

    public void setLandline(String landline) {
        Landline = landline;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public int getPitchTypeId() {
        return PitchTypeId;
    }

    public void setPitchTypeId(int pitchTypeId) {
        PitchTypeId = pitchTypeId;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getSubFacilityId() {
        return SubFacilityId;
    }

    public void setSubFacilityId(int subFacilityId) {
        SubFacilityId = subFacilityId;
    }

    public String getSubFacilityName() {
        return SubFacilityName;
    }

    public void setSubFacilityName(String subFacilityName) {
        SubFacilityName = subFacilityName;
    }

    public int getSubFacilityTypeId() {
        return SubFacilityTypeId;
    }

    public void setSubFacilityTypeId(int subFacilityTypeId) {
        SubFacilityTypeId = subFacilityTypeId;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }

    public ArrayList<FacilityBookings> getFacilitybookings() {
        return facilitybookings;
    }

    public void setFacilitybookings(ArrayList<FacilityBookings> facilitybookings) {
        this.facilitybookings = facilitybookings;
    }

    public ArrayList<FacilityCalenders> getFacilitycalendars() {
        return facilitycalendars;
    }

    public void setFacilitycalendars(ArrayList<FacilityCalenders> facilitycalendars) {
        this.facilitycalendars = facilitycalendars;
    }

    public int getFlooringtype() {
        return flooringtype;
    }

    public void setFlooringtype(int flooringtype) {
        this.flooringtype = flooringtype;
    }

    public int getGroundtype() {
        return groundtype;
    }

    public void setGroundtype(int groundtype) {
        this.groundtype = groundtype;
    }

    public int getPitchtype() {
        return pitchtype;
    }

    public void setPitchtype(int pitchtype) {
        this.pitchtype = pitchtype;
    }

    public int getPricingrule() {
        return pricingrule;
    }

    public void setPricingrule(int pricingrule) {
        this.pricingrule = pricingrule;
    }

    public int getSubfacilitytype() {
        return subfacilitytype;
    }

    public void setSubfacilitytype(int subfacilitytype) {
        this.subfacilitytype = subfacilitytype;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.AddressLine1);
        dest.writeString(this.AddressLine2);
        dest.writeString(this.AddressLine3);
        dest.writeString(this.City);
        dest.writeInt(this.CityId);
        dest.writeFloat(this.Distance);
        dest.writeInt(this.FacilityId);
        dest.writeInt(this.FlooringTypeId);
        dest.writeString(this.GPSCoordinates);
        dest.writeInt(this.GroundTypeId);
        dest.writeByte(this.HasAmbulance ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasBallPurchase ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasCafeteria ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasFirstAid ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasFloodLight ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasRestRoom ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasShoeRental ? (byte) 1 : (byte) 0);
        dest.writeByte(this.HasShower ? (byte) 1 : (byte) 0);
        dest.writeString(this.Image1URL);
        dest.writeString(this.Image2URL);
        dest.writeString(this.Image3URL);
        dest.writeString(this.Image4URL);
        dest.writeString(this.Image5URL);
        dest.writeByte(this.IsBookingAllowed ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsDefaultSubFacility ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsIndoor ? (byte) 1 : (byte) 0);
        dest.writeString(this.Landline);
        dest.writeString(this.Mobile);
        dest.writeString(this.Pincode);
        dest.writeInt(this.PitchTypeId);
        dest.writeString(this.State);
        dest.writeInt(this.SubFacilityId);
        dest.writeString(this.SubFacilityName);
        dest.writeInt(this.SubFacilityTypeId);
        dest.writeString(this.VideoURL);
        dest.writeList(this.facilitybookings);
        dest.writeList(this.facilitycalendars);
        dest.writeInt(this.flooringtype);
        dest.writeInt(this.groundtype);
        dest.writeInt(this.pitchtype);
        dest.writeInt(this.pricingrule);
        dest.writeInt(this.subfacilitytype);
    }

    public SubFacilities() {
    }

    protected SubFacilities(Parcel in) {
        this.AddressLine1 = in.readString();
        this.AddressLine2 = in.readString();
        this.AddressLine3 = in.readString();
        this.City = in.readString();
        this.CityId = in.readInt();
        this.Distance = in.readFloat();
        this.FacilityId = in.readInt();
        this.FlooringTypeId = in.readInt();
        this.GPSCoordinates = in.readString();
        this.GroundTypeId = in.readInt();
        this.HasAmbulance = in.readByte() != 0;
        this.HasBallPurchase = in.readByte() != 0;
        this.HasCafeteria = in.readByte() != 0;
        this.HasFirstAid = in.readByte() != 0;
        this.HasFloodLight = in.readByte() != 0;
        this.HasRestRoom = in.readByte() != 0;
        this.HasShoeRental = in.readByte() != 0;
        this.HasShower = in.readByte() != 0;
        this.Image1URL = in.readString();
        this.Image2URL = in.readString();
        this.Image3URL = in.readString();
        this.Image4URL = in.readString();
        this.Image5URL = in.readString();
        this.IsBookingAllowed = in.readByte() != 0;
        this.IsDefaultSubFacility = in.readByte() != 0;
        this.IsIndoor = in.readByte() != 0;
        this.Landline = in.readString();
        this.Mobile = in.readString();
        this.Pincode = in.readString();
        this.PitchTypeId = in.readInt();
        this.State = in.readString();
        this.SubFacilityId = in.readInt();
        this.SubFacilityName = in.readString();
        this.SubFacilityTypeId = in.readInt();
        this.VideoURL = in.readString();
        this.facilitybookings = new ArrayList<FacilityBookings>();
        in.readList(this.facilitybookings, FacilityBookings.class.getClassLoader());
        this.facilitycalendars = new ArrayList<FacilityCalenders>();
        in.readList(this.facilitycalendars, FacilityCalenders.class.getClassLoader());
        this.flooringtype = in.readInt();
        this.groundtype = in.readInt();
        this.pitchtype = in.readInt();
        this.pricingrule = in.readInt();
        this.subfacilitytype = in.readInt();
    }

    public static final Creator<SubFacilities> CREATOR = new Creator<SubFacilities>() {
        @Override
        public SubFacilities createFromParcel(Parcel source) {
            return new SubFacilities(source);
        }

        @Override
        public SubFacilities[] newArray(int size) {
            return new SubFacilities[size];
        }
    };
}
