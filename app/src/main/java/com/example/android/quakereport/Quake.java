package com.example.android.quakereport;

public class Quake {
    private double magnitude;
    private String place;
    private long date;
    private String url;

    public Quake(double mag,String plc,long dt,String link)
    {
        url=link;
        magnitude=mag;
        place=plc;
        date=dt;

    }

    public String getUrl() {
        return url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public long getDate() {

        return date;
    }
}
