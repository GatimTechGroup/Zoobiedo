package com.zoobiedo.org.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Venkatesh on 18-09-2016.
 */
public class Tournments {

    @SerializedName("name") public String name;
    @SerializedName("date") public String date;
    @SerializedName("price") public String price;

    public Tournments(String name, String price, String date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
