package com.example.user.hackust2016.Model;

import com.strongloop.android.loopback.Model;
import com.google.android.*;

import java.util.Date;

/**
 * Created by User on 4/16/2016.
 */
public class location extends Model{
    private boolean active;
    private Date time;
    private double longitude;
    private double latitude;



    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
