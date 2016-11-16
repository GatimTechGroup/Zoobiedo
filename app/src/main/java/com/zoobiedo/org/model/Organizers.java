package com.zoobiedo.org.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Venkatesh on 18-09-2016.
 */
public class Organizers {

    @SerializedName("name") public String name;
    @SerializedName("area") public String area;
    @SerializedName("member") public String member;
    @SerializedName("rating") public String rating;

    public Organizers(String name, String area, String member, String rating) {
        this.name = name;
        this.area = area;
        this.member = member;
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

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
