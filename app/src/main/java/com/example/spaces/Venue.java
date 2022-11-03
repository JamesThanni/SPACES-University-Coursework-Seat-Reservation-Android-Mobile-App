package com.example.spaces;

import android.graphics.drawable.Drawable;

public class Venue {
    int venueID;
    int Image;
    String Name;
    String Info;
    String Description;
    int Spaces;

    public Venue(int  image, String name, String info, String Description, int Spaces, int venueID) {
        Image = image;
        Name = name;
        Info = info;
        Description = Description;
        Spaces = Spaces;
        venueID = venueID;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getDesc() {
        return Description;
    }

    public void setDesc(String Description) {
        Description = Description;
    }

    public int getVenueID() {return venueID;}

    public void setVenueID(int venueID) {venueID = venueID;}

}
