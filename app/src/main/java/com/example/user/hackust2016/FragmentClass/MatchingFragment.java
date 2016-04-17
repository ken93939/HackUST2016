package com.example.user.hackust2016.FragmentClass;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.hackust2016.R;

/**
 * Created by loyuman on 17/4/2016.
 */
public class MatchingFragment extends Fragment {
    String option;

    public MatchingFragment() {

    }

    public void setOption(String option) {
        this.option = option;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_matching, container, false);

        MatchResultFragment mRF = new MatchResultFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.match_container, mRF);
        transaction.commit();
        return v;
    }
}
