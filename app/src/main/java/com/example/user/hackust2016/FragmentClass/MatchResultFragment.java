package com.example.user.hackust2016.FragmentClass;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.hackust2016.R;
import com.example.user.hackust2016.matchreturned;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam-PC on 17/4/2016.
 */
public class MatchResultFragment extends Fragment {
    private ArrayList<matchreturned> list;
    private String TAG=MatchingFragment.class.getCanonicalName();
    public MatchResultFragment() {

    }

    public void setList(ArrayList<matchreturned> list) {
        this.list = list;
        Log.i(TAG," "+list.size() );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_matchfound, container, false);
        /*String[] array = {"a", "b", "c", "d", "e"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < array.length; ++i) {
            list.add(array[i]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, list);*/

        ListView listView = (ListView) v.findViewById(R.id.listView);

//        matchreturned match_data[] = new matchreturned[]
//                {
//                        new matchreturned("A", "usericon"),
//                        new matchreturned("B", "usericon"),
//                        new matchreturned("C", "usericon"),
//                        new matchreturned("D", "usericon"),
//                };

//        final ArrayList<matchreturned> list = new ArrayList<matchreturned>();
//        for (int i = 0; i < match_data.length; ++i) {
//            list.add(match_data[i]);
//        }
        Log.d(TAG, "fuck");
        MatchResultAdapter madapter = new MatchResultAdapter(getActivity(),
                R.layout.match_list_item, list);

        listView.setAdapter(madapter);
        /*ArrayAdapter adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.fragment_matchfound, array);

        ListView listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(adapter);*/
        return v;
    }

}
