package com.zoobiedo.org.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Venkatesh on 30-09-2016.
 */
public class RegisterObject {

    @SerializedName("__type")
    private String _type;
    @SerializedName("AddressLine1")
    private String addressLine1;
    @SerializedName("AddressLine2")
    private String addressLine2;
    @SerializedName("AddressLine3")
    private String addressLine3;
    @SerializedName("BookingUserId")
    private int bookingUserId;
    @SerializedName("City")
    private String city;
    @SerializedName("DateOfBirth")
    private String dob;
    @SerializedName("FacebookUserId")
    private String facebookUserId;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("GoogleUserId")
    private String googleUserId;
    @SerializedName("IsEmailVerified")
    private boolean isEmailVerified;
    @SerializedName("IsFacebookLogin")
    private boolean isFacebookLogin;
    @SerializedName("IsGoogleLogin")
    private boolean isGoogleLogin;
    @SerializedName("IsMobileVerified")
    private boolean isMobileVerified;
    @SerializedName("IsRegistered")
    private boolean isRegistered;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("MiddleName")
    private String middleName;
    @SerializedName("Mobile")
    private String mobile;
    @SerializedName("MobileActivationCode")
    private String mobileActivationCode;
    @SerializedName("Password")
    private String password;
    @SerializedName("Pincode")
    private String pincode;
    @SerializedName("State")
    private String state;
    @SerializedName("UserName")
    private String userName;
    @SerializedName("appdeviceactivations")
    private List<AppDeviceActivations> appDeviceActivations;
    @SerializedName("customernotifications")
    private List<CustomerNotifications> customerNotifications;
    @SerializedName("facilitybookings")
    private List<FacilityCalenders> facilityBookings;
    @SerializedName("practicematchrequests")
    private List<PracticeMatchRequest> practiceMatchRequest;
    @SerializedName("recoverycodes")
    private List<RecoveryCodes> recoveryCodes;

    public int getBookingUserId() {
        return bookingUserId;
    }

    public void setBookingUserId(int bookingUserId) {
        this.bookingUserId = bookingUserId;
    }

    public List<AppDeviceActivations> getAppDeviceActivations() {
        return appDeviceActivations;
    }

    public void setAppDeviceActivations(List<AppDeviceActivations> appDeviceActivations) {
        this.appDeviceActivations = appDeviceActivations;
    }

    public List<CustomerNotifications> getCustomerNotifications() {
        return customerNotifications;
    }

    public void setCustomerNotifications(List<CustomerNotifications> customerNotifications) {
        this.customerNotifications = customerNotifications;
    }

    public List<FacilityCalenders> getFacilityBookings() {
        return facilityBookings;
    }

    public void setFacilityBookings(List<FacilityCalenders> facilityBookings) {
        this.facilityBookings = facilityBookings;
    }

    public List<PracticeMatchRequest> getPracticeMatchRequest() {
        return practiceMatchRequest;
    }

    public void setPracticeMatchRequest(List<PracticeMatchRequest> practiceMatchRequest) {
        this.practiceMatchRequest = practiceMatchRequest;
    }

    public List<RecoveryCodes> getRecoveryCodes() {
        return recoveryCodes;
    }

    public void setRecoveryCodes(List<RecoveryCodes> recoveryCodes) {
        this.recoveryCodes = recoveryCodes;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFacebookUserId() {
        return facebookUserId;
    }

    public void setFacebookUserId(String facebookUserId) {
        this.facebookUserId = facebookUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        this.googleUserId = googleUserId;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public boolean isFacebookLogin() {
        return isFacebookLogin;
    }

    public void setIsFacebookLogin(boolean isFacebookLogin) {
        this.isFacebookLogin = isFacebookLogin;
    }

    public boolean isGoogleLogin() {
        return isGoogleLogin;
    }

    public void setIsGoogleLogin(boolean isGoogleLogin) {
        this.isGoogleLogin = isGoogleLogin;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileActivationCode() {
        return mobileActivationCode;
    }

    public void setMobileActivationCode(String mobileActivationCode) {
        this.mobileActivationCode = mobileActivationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}
