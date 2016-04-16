package com.example.user.hackust2016;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.user.hackust2016.FragmentClass.fragmentQuestion;
/**
 * Created by loyuman on 16/4/2016.
 */
public class MatchActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        fragmentQuestion fQ = new fragmentQuestion();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.match_container, fQ);
        transaction.commit();
    }
}
