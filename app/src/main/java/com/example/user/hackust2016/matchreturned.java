package com.example.user.hackust2016;

/**
 * Created by User on 4/17/2016.
 */
public class matchreturned {
    private String username;
    private String picture;

    public matchreturned(String uname, String pic){
        username=uname;
        picture=pic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
