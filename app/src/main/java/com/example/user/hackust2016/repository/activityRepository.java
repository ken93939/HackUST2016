package com.example.user.hackust2016.repository;

import com.example.user.hackust2016.Model.activity;
import com.strongloop.android.loopback.ModelRepository;

/**
 * Created by User on 4/16/2016.
 */
public class activityRepository extends ModelRepository<activity> {
    public activityRepository() {
        super("activity", activity.class);
    }

}
