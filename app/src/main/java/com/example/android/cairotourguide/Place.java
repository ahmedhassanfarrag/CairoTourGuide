package com.example.android.cairotourguide;

/**
 * Created by AHMED HASSAN on 4/23/2018.
 */
public class Place {
    // Name of the Place.
    private String mPlaceName;
    // Drawable resource ID (image of place).
    private int mPlaceImage;
    // Name of the Place in category layout.
    private String mMuseumName;
    // Image of the Place in category layout.
    private int mMuseumImage;
    // info of the Place in category layout.
    private String mMuseumInfo;
    //  name of place location in category layout.
    private String mLocation;
    //  phone number of the place in category layout.
    private String mNumber;


    //Create a new places object.
    public Place(String mName, int imageArtist, String MuseumName, int MuseumImage, String MuseumInfo, String location, String number) {
        mPlaceName = mName;
        mPlaceImage = imageArtist;
        mMuseumName = MuseumName;
        mMuseumImage = MuseumImage;
        mMuseumInfo = MuseumInfo;
        mLocation = location;
        mNumber = number;
    }

    // Get the name of the place.
    public String getmPlaceName() {
        return mPlaceName;
    }

    // Get the image of the place.
    public int getmPlaceImage() {
        return mPlaceImage;
    }

    // Get the name of the place in category layout.
    public String getmMuseumName() {
        return mMuseumName;
    }

    // Get the image of the place in category layout.
    public int getmMuseumImage() {
        return mMuseumImage;
    }

    // Get the information of the place in category layout.
    public String getmMuseumInfo() {
        return mMuseumInfo;
    }

    // Get the location of the place in category layout.
    public String getmLocation() {
        return mLocation;
    }

    // Get phone number of the place in category layout.
    public String getmNumber() {
        return mNumber;
    }
}
