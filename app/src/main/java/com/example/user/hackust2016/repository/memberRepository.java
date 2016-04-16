package com.example.user.hackust2016.repository;

import com.example.user.hackust2016.Model.member;
import com.strongloop.android.loopback.UserRepository;

/**
 * Created by User on 4/17/2016.
 */
public class memberRepository extends UserRepository<member> {
    public memberRepository() {
        super("member", null,member.class);
    }
}
