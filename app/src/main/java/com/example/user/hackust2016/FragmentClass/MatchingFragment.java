package com.example.user.hackust2016.FragmentClass;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.hackust2016.Constants;
import com.example.user.hackust2016.R;
import com.example.user.hackust2016.matchreturned;
import com.example.user.hackust2016.repository.activityRepository;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import java.util.List;

/**
 * Created by loyuman on 17/4/2016.
 */
public class MatchingFragment extends Fragment {
    String option;
    private RestAdapter adapter;
    private String TAG=MatchingFragment.class.getCanonicalName();
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new RestAdapter(getActivity().getApplicationContext(),Constants.serverIp);
        possibleMatch();

    }
    private void possibleMatch(){
        activityRepository activityRepository= adapter.createRepository(com.example.user.hackust2016.repository.activityRepository.class);
        activityRepository.possibleMatch("Movie", new ListCallback() {
            @Override
            public void onSuccess(List objects) {
                Log.i(TAG, "possiblematchsuccess");
                for (Object obj : objects) {
                    matchreturned match = (matchreturned) obj;
                    Log.i(TAG, "" + match.getUsername() + match.getPicture());
                }
            }

            @Override
            public void onError(Throwable t) {
                Log.i(TAG, t.getLocalizedMessage());
            }
        });
    }

}
