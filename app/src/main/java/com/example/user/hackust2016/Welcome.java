package com.example.user.hackust2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.user.hackust2016.Model.activity;
import com.example.user.hackust2016.Model.location;
import com.example.user.hackust2016.repository.activityRepository;
import com.example.user.hackust2016.repository.locationRepository;
//import com.google.android.maps.GeoPoint;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import java.util.Date;

public class Welcome extends AppCompatActivity {
    private GestureDetector mDetector;
    private int page;
    private RestAdapter adapter;
    private final String TAG= Welcome.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        page=0;
        adapter= new RestAdapter(getApplicationContext(),Constants.serverIp);
//        activityRepository repository = adapter.createRepository(activityRepository.class);
//        activity activity = repository.createObject(ImmutableMap.of("name","activity"));
//        activity.setName("basketball");
//        activity.setNature("down");
//        activity.save(new VoidCallback() {
//            @Override
//            public void onSuccess() {
//                Log.i(TAG,"yo swag");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.i(TAG,"fuck you" +t.getLocalizedMessage());
//            }
//        });
//        locationRepository repository = adapter.createRepository(locationRepository.class);
//        location location = repository.createObject(ImmutableMap.of("name", "location"));
//        GeoPoint gp=new GeoPoint(12,22);
//        location.setGp(gp);
//        location.setActive(false);
//        location.setTime(new Date());
//        location.save(new VoidCallback() {
//            @Override
//            public void onSuccess() {
//                Log.i(TAG,"yo swag");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.i(TAG,"fuck you" +t.getLocalizedMessage());
//            }
//        });
    }
    private class swipeWelcome extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

}
