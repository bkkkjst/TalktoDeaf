package com.talktodeaf.project.talktodeaf.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by wiwat on 1/22/2015.
 */

@Parcel
public class Example
{
    @SerializedName("des_voc")
    private String desVoc;

    @SerializedName("name_voc")
    private String nameVoc;

    //Getters and setters

    public String getDesVoc() {
        return desVoc;
    }

    public String getNameVoc() {
        return nameVoc;
    }
}
