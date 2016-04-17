package com.example.user.hackust2016.FragmentClass;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.hackust2016.Constants;
import com.example.user.hackust2016.R;
import com.example.user.hackust2016.repository.activityRepository;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

/**
 * Created by loyuman on 16/4/2016.
 */
public class fragmentChooseOption extends Fragment {
    int value;
    private RestAdapter restAdapter;
    String question, but1, but2, but3, but4, but5;
    String LOG_TAG = fragmentChooseOption.class.getSimpleName();

    public fragmentChooseOption() {
    }

    public void setValue(int value){
        this.value = value;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chooseoption, container, false);
        setText(v);
        return v;
    }
    private void setText(View v){
        if(value == 1){
            question = "Let's make it more interesting";
            but1 = "Hiking";
            but2 = "Hotpot";
            but3 = "Fitness";
            but4 = "Karaoke";
            but5 = "Sports";
        }else if(value == 2){
            question = "Cheer up!\nLet's make it better";
            but1 = "Movie";
            but2 = "Cycling";
            but3 = "Sports";
            but4 = "Clubbing";
            but5 = "Beach";
        }else if(value == 3){
            question = "Don't Worry!\nLet's be happy";
            but1 = "Clubbing";
            but2 = "Blind date";
            but3 = "Movie";
            but4 = "Restaurant";
            but5 = "Yoga";
        }else{
            question = "error";
            but1 = "error";
            but2 = "error";
            but3 = "error";
            but4 = "error";
            but5 = "error";
        }

        TextView textView = (TextView) v.findViewById(R.id.chooseoption_question);
        textView.setText(question);
        Button button1 = (Button) v.findViewById(R.id.chooseoption_button1);
        Button button2 = (Button) v.findViewById(R.id.chooseoption_button2);
        Button button3 = (Button) v.findViewById(R.id.chooseoption_button3);
        Button button4 = (Button) v.findViewById(R.id.chooseoption_button4);
        Button button5 = (Button) v.findViewById(R.id.chooseoption_button5);
        button1.setText(but1);
        button2.setText(but2);
        button3.setText(but3);
        button4.setText(but4);
        button5.setText(but5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MatchingFragment mF = new MatchingFragment();
//                mF.setOption(but1);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.match_container, mF);
//                transaction.commit();
                addActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MatchingFragment mF = new MatchingFragment();
//                mF.setOption(but2);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.match_container, mF);
//                transaction.commit();
                addActivity();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MatchingFragment mF = new MatchingFragment();
//                mF.setOption(but3);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.match_container, mF);
//                transaction.commit();
                addActivity();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MatchingFragment mF = new MatchingFragment();
//                mF.setOption(but4);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.match_container, mF);
//                transaction.commit();
                addActivity();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MatchingFragment mF = new MatchingFragment();
//                mF.setOption(but5);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.match_container, mF);
//                transaction.commit();
                addActivity();
            }
        });

    }

    private void addActivity(){
        restAdapter=new RestAdapter(getActivity().getApplicationContext(), Constants.serverIp);
        activityRepository activityRepository=restAdapter.createRepository(com.example.user.hackust2016.repository.activityRepository.class);
        activityRepository.addActivity("Movie", "up", new VoidCallback() {
            @Override
            public void onSuccess() {
                Log.i(LOG_TAG, "success");
                MatchingFragment mF = new MatchingFragment();
                mF.setOption(but5);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.match_container, mF);
                transaction.commit();
            }

            @Override
            public void onError(Throwable t) {
                Log.i(LOG_TAG,t.getLocalizedMessage());
            }
        });
    }
}
