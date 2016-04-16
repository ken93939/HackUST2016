package com.example.user.hackust2016.repository;

import com.example.user.hackust2016.Model.location;
import com.strongloop.android.loopback.ModelRepository;

/**
 * Created by User on 4/16/2016.
 */
public class locationRepository extends ModelRepository<location> {
    public locationRepository() {
        super("location", location.class);
    }
}
