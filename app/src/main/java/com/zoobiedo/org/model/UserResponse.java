package com.zoobiedo.org.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Venkatesh on 01-10-2016.
 */
public class UserResponse {

    @SerializedName("ErrorCode")
    private String errorCode;
    @SerializedName("InformationCode")
    private String informationCode;
    @SerializedName("ResponseObject")
    private RegisterObject mRegisterDetails;
    @SerializedName("WarningCode")
    private String warningCOde;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getInformationCode() {
        return informationCode;
    }

    public void setInformationCode(String informationCode) {
        this.informationCode = informationCode;
    }

    public RegisterObject getmRegisterDetails() {
        return mRegisterDetails;
    }

    public void setmRegisterDetails(RegisterObject mRegisterDetails) {
        this.mRegisterDetails = mRegisterDetails;
    }

    public String getWarningCOde() {
        return warningCOde;
    }

    public void setWarningCOde(String warningCOde) {
        this.warningCOde = warningCOde;
    }
}
