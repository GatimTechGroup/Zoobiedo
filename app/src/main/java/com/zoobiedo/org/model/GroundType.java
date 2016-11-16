package com.zoobiedo.org.model;

/**
 * Created by Venkatesh on 27-09-2016.
 */
public class GroundType {

    private String icon;
    private String groundName;

    public GroundType(String icon,String groundName)
    {
        this.icon = icon;
        this.groundName = groundName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }
}
