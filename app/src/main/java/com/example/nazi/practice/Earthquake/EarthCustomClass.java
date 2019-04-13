package com.example.nazi.practice.Earthquake;

import android.net.Uri;
import android.widget.ArrayAdapter;

import java.net.URL;

/**
 * Created by Nazi on 12/30/2018.
 */

public class EarthCustomClass  {
    private String mMagnitude;
    private String mLocation;
    private String mDate;
    private String Url;
    //Construct a new (@link EarthQuake) objects.
    public EarthCustomClass(String magnitude, String location, String date, String url)
    {
        this.mMagnitude=magnitude;//assigning value;
        this.mLocation=location;
        this.mDate=date;
        this.Url = url;

    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }

    public String getUrl() { return Url; }
}
