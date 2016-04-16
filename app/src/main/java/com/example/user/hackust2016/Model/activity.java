package com.example.user.hackust2016.Model;

import com.strongloop.android.loopback.Model;

/**
 * Created by User on 4/16/2016.
 */
public class activity extends Model{
    private String name;
    private String nature;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setNature(String nature){
        this.nature=nature;
    }
    public String getNature(){
        return this.nature;
    }

}
