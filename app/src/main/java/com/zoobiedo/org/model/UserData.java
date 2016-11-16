package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Venkatesh on 01-10-2016.
 */
public class UserData implements Parcelable {

    private String  AddressLine1;
    private String  AddressLine2;
    private String  AddressLine3;
    private int BookingUserId;
    private  String City;
    private String DateOfBirth;
    private int Device;
    private String  DeviceActivationCode;
    private String FacebookUserId;
    private String FirstName;
    private String GoogleUserId;
    private boolean IsEmailVerified;
    private boolean IsFacebookLogin;
    private boolean IsGoogleLogin;
    private boolean IsMobileVerified;
    private boolean IsRegistered;
    private String LastName;
    private String MiddleName;
    private String Mobile;
    private String MobileActivationCode;
    private String Password;
    private String Pincode;
    private String State;
    private String UserName;



    public int getBookingUserId() {
        return BookingUserId;
    }

    public void setBookingUserId(int bookingUserId) {
        BookingUserId = bookingUserId;
    }

    public int getDevice() {
        return Device;
    }

    public void setDevice(int device) {
        Device = device;
    }

    public boolean isEmailVerified() {
        return IsEmailVerified;
    }

    public void setIsEmailVerified(boolean isEmailVerified) {
        IsEmailVerified = isEmailVerified;
    }

    public boolean isFacebookLogin() {
        return IsFacebookLogin;
    }

    public void setIsFacebookLogin(boolean isFacebookLogin) {
        IsFacebookLogin = isFacebookLogin;
    }

    public boolean isGoogleLogin() {
        return IsGoogleLogin;
    }

    public void setIsGoogleLogin(boolean isGoogleLogin) {
        IsGoogleLogin = isGoogleLogin;
    }

    public boolean isMobileVerified() {
        return IsMobileVerified;
    }

    public void setIsMobileVerified(boolean isMobileVerified) {
        IsMobileVerified = isMobileVerified;
    }
    public boolean isRegistered() {
        return IsRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        IsRegistered = isRegistered;
    }

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

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }


    public String getDeviceActivationCode() {
        return DeviceActivationCode;
    }

    public void setDeviceActivationCode(String deviceActivationCode) {
        DeviceActivationCode = deviceActivationCode;
    }

    public String getFacebookUserId() {
        return FacebookUserId;
    }

    public void setFacebookUserId(String facebookUserId) {
        FacebookUserId = facebookUserId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getGoogleUserId() {
        return GoogleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        GoogleUserId = googleUserId;
    }



    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getMobileActivationCode() {
        return MobileActivationCode;
    }

    public void setMobileActivationCode(String mobileActivationCode) {
        MobileActivationCode = mobileActivationCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
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
        dest.writeInt(this.BookingUserId);
        dest.writeString(this.City);
        dest.writeString(this.DateOfBirth);
        dest.writeInt(this.Device);
        dest.writeString(this.DeviceActivationCode);
        dest.writeString(this.FacebookUserId);
        dest.writeString(this.FirstName);
        dest.writeString(this.GoogleUserId);
        dest.writeByte(this.IsEmailVerified ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsFacebookLogin ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsGoogleLogin ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsMobileVerified ? (byte) 1 : (byte) 0);
        dest.writeByte(this.IsRegistered ? (byte) 1 : (byte) 0);
        dest.writeString(this.LastName);
        dest.writeString(this.MiddleName);
        dest.writeString(this.Mobile);
        dest.writeString(this.MobileActivationCode);
        dest.writeString(this.Password);
        dest.writeString(this.Pincode);
        dest.writeString(this.State);
        dest.writeString(this.UserName);
    }

    public UserData() {
    }

    protected UserData(Parcel in) {
        this.AddressLine1 = in.readString();
        this.AddressLine2 = in.readString();
        this.AddressLine3 = in.readString();
        this.BookingUserId = in.readInt();
        this.City = in.readString();
        this.DateOfBirth = in.readString();
        this.Device = in.readInt();
        this.DeviceActivationCode = in.readString();
        this.FacebookUserId = in.readString();
        this.FirstName = in.readString();
        this.GoogleUserId = in.readString();
        this.IsEmailVerified = in.readByte() != 0;
        this.IsFacebookLogin = in.readByte() != 0;
        this.IsGoogleLogin = in.readByte() != 0;
        this.IsMobileVerified = in.readByte() != 0;
        this.IsRegistered = in.readByte() != 0;
        this.LastName = in.readString();
        this.MiddleName = in.readString();
        this.Mobile = in.readString();
        this.MobileActivationCode = in.readString();
        this.Password = in.readString();
        this.Pincode = in.readString();
        this.State = in.readString();
        this.UserName = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel source) {
            return new UserData(source);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };
}
