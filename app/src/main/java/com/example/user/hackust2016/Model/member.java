package com.example.user.hackust2016.Model;

import com.strongloop.android.loopback.User;

/**
 * Created by User on 4/17/2016.
 */
public class member extends User {
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
