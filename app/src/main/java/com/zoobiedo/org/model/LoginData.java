package com.zoobiedo.org.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Venkatesh on 01-10-2016.
 */
public class LoginData implements Parcelable{

    private String UserName;
    private String  DeviceActivationCode;
    private String FacebookUserId;
    private String FirstName;
    private String GoogleUserId;
    private String Password;
    private String MiddleName;
    private String LastName;
    private int Device;
    private int loginMode;
    private String EmailAddress;



    public int getDevice() {
        return Device;
    }

    public void setDevice(int device) {
        Device = device;
    }

    public int getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(int loginMode) {
        this.loginMode = loginMode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }



    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public LoginData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.UserName);
        dest.writeString(this.DeviceActivationCode);
        dest.writeString(this.FacebookUserId);
        dest.writeString(this.FirstName);
        dest.writeString(this.GoogleUserId);
        dest.writeString(this.Password);
        dest.writeString(this.MiddleName);
        dest.writeString(this.LastName);
        dest.writeInt(this.Device);
        dest.writeInt(this.loginMode);
        dest.writeString(this.EmailAddress);
    }

    protected LoginData(Parcel in) {
        this.UserName = in.readString();
        this.DeviceActivationCode = in.readString();
        this.FacebookUserId = in.readString();
        this.FirstName = in.readString();
        this.GoogleUserId = in.readString();
        this.Password = in.readString();
        this.MiddleName = in.readString();
        this.LastName = in.readString();
        this.Device = in.readInt();
        this.loginMode = in.readInt();
        this.EmailAddress = in.readString();
    }

    public static final Creator<LoginData> CREATOR = new Creator<LoginData>() {
        @Override
        public LoginData createFromParcel(Parcel source) {
            return new LoginData(source);
        }

        @Override
        public LoginData[] newArray(int size) {
            return new LoginData[size];
        }
    };
}
