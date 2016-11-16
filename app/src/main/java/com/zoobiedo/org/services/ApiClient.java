package com.zoobiedo.org.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Venkatesh on 06-09-2016.
 */
public class ApiClient {

    public static final String BASE_URL_MGT = "http://test.deliverain.com:10408/Services/CustomerManagement.svc/";
    public static final String BASE_URL_CUST = "http://test.deliverain.com:10408/Services/CustomerBooking.svc/";
    private static Retrofit mRetrofit = null;


    public static Retrofit getRetrofitClientManagement()
    {
        if(mRetrofit == null)
        {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MGT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }else
        {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MGT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static Retrofit getRetrofitClientCustomerBooking()
    {
        if(mRetrofit == null)
        {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_CUST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }else
        {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_CUST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }}
