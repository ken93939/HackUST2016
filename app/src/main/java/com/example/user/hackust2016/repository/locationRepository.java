package com.example.user.hackust2016.repository;

import com.example.user.hackust2016.Model.location;
import com.google.common.collect.ImmutableMap;
import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.Adapter;
import com.strongloop.android.remoting.adapters.RestContract;
import com.strongloop.android.remoting.adapters.RestContractItem;

/**
 * Created by User on 4/16/2016.
 */
public class locationRepository extends ModelRepository<location> {
    public locationRepository() {
        super("location", location.class);
    }

    public RestContract createContract(){
        RestContract contract= super.createContract();
        contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/addLocation", "POST"),
                getClassName() + ".addLocation");
        return contract;
    }

    public void addLocation(double latitude, double longitude, final VoidCallback callback){
        invokeStaticMethod("addLocation", ImmutableMap.of("lat", latitude, "lng", longitude), new Adapter.Callback() {
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
}
