package com.zoobiedo.org.services;


import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.FacilitySlotsRequestData;
import com.zoobiedo.org.model.LoginData;
import com.zoobiedo.org.model.RegisterObject;
import com.zoobiedo.org.model.UserData;
import com.zoobiedo.org.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Venkatesh on 06-09-2016.
 */
//veda094
public interface ApiInterface {

    @Headers({
            "SecurityToken: TestString",
            "ProtocolVersion: 1.0",
            "Content-Type: application/json"
    })
    @POST("RegisterUser")
    Call<UserResponse> postRegisterUser(@Body UserData data);

    @Headers({
            "SecurityToken: TestString",
            "ProtocolVersion: 1.0",
            "Content-Type: application/json"
    })
    @POST("Authenticate")
    Call<UserResponse> postRegisterUserSocial(@Body LoginData data);

    @Headers({
            "SecurityToken: TestString",
            "ProtocolVersion: 1.0",
            "Content-Type: application/json"
    })
    @POST("SearchFacilities")
    Call<ArrayList<FacilitySlots>> getListOfFacilitySlots(@Body FacilitySlotsRequestData data);




}
