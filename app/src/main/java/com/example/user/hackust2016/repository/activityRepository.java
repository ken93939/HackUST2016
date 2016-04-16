package com.example.user.hackust2016.repository;

import android.util.Log;


import com.example.user.hackust2016.Model.activity;
import com.example.user.hackust2016.matchreturned;
import com.google.common.collect.ImmutableMap;
import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.Adapter;
import com.strongloop.android.remoting.adapters.RestContract;
import com.strongloop.android.remoting.adapters.RestContractItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 4/16/2016.
 */
public class activityRepository extends ModelRepository<activity> {
    private String TAG="welcome";
    public activityRepository() {
        super("activity", activity.class);
    }

    public RestContract createContract(){
        RestContract contract= super.createContract();
        contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/addActivity", "POST"),
                getClassName() + ".addActivity");
        contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/possibleMatch", "POST"),
                getClassName() + ".possibleMatch");
        return contract;
    }

    public void addLocation(String name, String nature, final VoidCallback callback){
        invokeStaticMethod("addLocation", ImmutableMap.of("name", name, "nature", nature), new Adapter.Callback() {
            @Override
            public void onSuccess(String response) {
                callback.onSuccess();
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void possibleMatch(String name, final ListCallback callback){
        invokeStaticMethod("possibleMatch", ImmutableMap.of("name",name), new Adapter.Callback(){

            @Override
            public void onSuccess(String response) {
                Log.i(TAG, response);
                List<matchreturned> matchreturnedList=new ArrayList<matchreturned>();
                try {
                    JSONObject obj= new JSONObject(response);
                    JSONArray data= obj.getJSONArray("data");
                    for(int i=0;i<data.length();i++){
                        JSONObject json= data.getJSONObject(i);
                        matchreturned matchreturned= new matchreturned(json.getString("username"),json.getString("picture"));
                        matchreturnedList.add(matchreturned);
                    }
                    callback.onSuccess(matchreturnedList);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i(TAG,e.getLocalizedMessage());
                }

            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }

}
