package com.example.user.hackust2016.FragmentClass;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.hackust2016.R;

/**
 * Created by loyuman on 16/4/2016.
 */
public class fragmentQuestion extends Fragment {
    int value = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        at.markushi.ui.CircleButton button1 = (at.markushi.ui.CircleButton) v.findViewById(R.id.circleButton1);
        at.markushi.ui.CircleButton button2 = (at.markushi.ui.CircleButton) v.findViewById(R.id.circleButton2);
        at.markushi.ui.CircleButton button3 = (at.markushi.ui.CircleButton) v.findViewById(R.id.circleButton3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 1;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 2;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 3;
            }
        });
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
