package com.zoobiedo.org.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Venkatesh on 16-09-2016.
 */
public class Grounds implements Serializable{

    @SerializedName("name") public String name;
    @SerializedName("area") public String area;
    @SerializedName("distance") public String distance;
    @SerializedName("rating") public String rating;

    public Grounds(String name,String area,String distance,String rating)
    {
        this.name = name;
        this.distance = distance;
        this.area = area;
        this.rating = rating;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
