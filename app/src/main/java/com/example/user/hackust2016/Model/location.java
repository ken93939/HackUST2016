package com.example.user.hackust2016.Model;

//import com.google.android.maps.GeoPoint;
import com.strongloop.android.loopback.Model;
import com.google.android.*;

import java.util.Date;

/**
 * Created by User on 4/16/2016.
 */
public class location extends Model{
//    private GeoPoint gp;
    private boolean active;
    private Date time;

//    public GeoPoint getGp() {
//        return gp;
//    }
//
//    public void setGp(GeoPoint gp) {
//        this.gp = gp;
//    }

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
