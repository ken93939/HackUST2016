package com.example.user.hackust2016;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.user.hackust2016.Model.activity;
import com.example.user.hackust2016.Model.location;
import com.example.user.hackust2016.Model.member;
import com.example.user.hackust2016.repository.activityRepository;
import com.example.user.hackust2016.repository.locationRepository;
import com.example.user.hackust2016.repository.memberRepository;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.location.LocationServices;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.strongloop.android.loopback.AccessToken;
import com.strongloop.android.loopback.LocalInstallation;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.UserRepository;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Welcome extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GestureDetector mDetector;
    private int page;
    private RestAdapter adapter;
    private final String TAG = Welcome.class.getCanonicalName();
    private int PERMISSIONS_CODE = 123321;
    String mprovider;
    private GoogleApiClient googleApiClient;
    private Location mLastLocation;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        page = 0;
        adapter = new RestAdapter(getApplicationContext(), Constants.serverIp);

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

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }


//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_CODE);
//            Log.i(TAG,"ask");
//        }
//        else{
//            Log.i(TAG,"obtained");
//        }
//        LocationManager locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Criteria criteria= new Criteria();
//        mprovider = locationManager.getBestProvider(criteria,false);
//        if(mprovider!=null && !mprovider.equals("")){
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            Log.i(TAG,"mprovidernotnull"+mprovider);
//            Location location = locationManager.getLastKnownLocation(mprovider);
//            locationManager.requestLocationUpdates(mprovider, 1000, 1, this);
//            if (location != null)
//                onLocationChanged(location);
//            else{
//                Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_SHORT).show();
//            }
//        }


//        locationRepository repository = adapter.createRepository(locationRepository.class);
//        location dblocation = repository.createObject(ImmutableMap.of("name", "location"));
//        dblocation.setActive(true);
//
//        dblocation.save(new VoidCallback() {
//            @Override
//            public void onSuccess() {
//                Log.i(TAG, "yo swag");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.i(TAG, "fuck you" + t.getLocalizedMessage());
//            }
//        });
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode == PERMISSIONS_CODE){
//
//        }
        if (requestCode == PERMISSIONS_CODE) {
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "fail to pass permission");
                return;
            }
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.i(TAG, "" + location.getLatitude() + location.getLongitude());
            Toast.makeText(this, "" + location.getLongitude() + location.getLatitude(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i(TAG, "changed" + location.getLatitude() + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (mLastLocation != null) {
            Log.i(TAG,""+mLastLocation.getLatitude()+mLastLocation.getLongitude());
            memberRepository memberRepository= adapter.createRepository(com.example.user.hackust2016.repository.memberRepository.class);
            memberRepository.loginUser("f@f.com", "123456", new UserRepository.LoginCallback<member>() {
                @Override
                public void onSuccess(AccessToken token, member currentUser) {
                    Log.i(TAG,"login successful");
                    submitLocation(mLastLocation);
                    possibleMatch();
                }

                @Override
                public void onError(Throwable t) {
                    Log.i(TAG,"failed"+t.getLocalizedMessage());
                }
            });
        }
        else{
            Log.i(TAG,"WTF");
        }
    }

    private void possibleMatch(){
        activityRepository activityRepository= adapter.createRepository(com.example.user.hackust2016.repository.activityRepository.class);
        activityRepository.possibleMatch("Movie", new ListCallback() {
            @Override
            public void onSuccess(List objects) {
                Log.i(TAG,"possiblematchsuccess");
                for (Object obj: objects){
                    matchreturned match=(matchreturned)obj;
                    Log.i(TAG,""+match.getUsername()+match.getPicture());
                }
            }

            @Override
            public void onError(Throwable t) {
                Log.i(TAG,t.getLocalizedMessage());
            }
        });
    }
    private void submitLocation(Location location){
        locationRepository locationRepository= adapter.createRepository(locationRepository.class);
        location location1= locationRepository.createObject(ImmutableMap.of("name","test"));
        location1.setActive(true);
        location1.setLongitude(location.getLongitude());
        location1.setLatitude(location.getLatitude());
        locationRepository.addLocation(location.getLatitude(),location.getLongitude(), new VoidCallback(){
            @Override
            public void onSuccess() {
                Log.i(TAG,"location success");
            }

            @Override
            public void onError(Throwable t) {
                Log.i(TAG,t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    private class swipeWelcome extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    private class tokenAsyn extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... params) {
            InstanceID instanceID= InstanceID.getInstance(Welcome.this);
            String authorizedEntity ="213242149938";
            try {
                String token= instanceID.getToken(authorizedEntity, GoogleCloudMessaging.INSTANCE_ID_SCOPE,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(checkPlayServices()){
                final LocalInstallation installation= new LocalInstallation(Welcome.this,adapter);
                installation.setAppId("hackathon");
                installation.setUserId("testing");
                installation.setSubscriptions(new String[]{"all"});
                if(installation.getDeviceToken()!=null){
//                    saveInstallation(installation);
                }
                else{
                    registerInBackground(installation);
                }

            }
        }
    }

    private void registerInBackground(final LocalInstallation installation) {
//        new AsyncTask<Void, Void, Exception>() {
//            @Override
//            protected Exception doInBackground(final Void... params) {
//                try {
//                    GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(Welcome.this);
//                    // substitute 12345 with the real Google API Project number
//                    final String regid = gcm.register("213242149938");
//                    installation.setDeviceToken(regid);
//                    return null;
//                } catch (final IOException ex) {
//                    return ex;
//                    // If there is an error, don't just keep trying to
//                    // register.
//                    // Require the user to click a button again, or perform
//                    // exponential back-off.
//                }
//            }
//            @Override
//            protected void onPostExecute(final Exception error) {
//                if (err != null) {
//                    Log.e(TAG, "GCM Registration failed.", error);
//                } else {
//                    saveInstallation(installation);
//                }
//            }
//        }.execute(null, null, null);
    }


}
