package com.example.user.hackust2016.FragmentClass;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.hackust2016.R;
import com.example.user.hackust2016.matchreturned;

import java.util.ArrayList;

/**
 * Created by Sam-PC on 17/4/2016.
 */
public class MatchResultAdapter extends ArrayAdapter<matchreturned> {

    Context context;
    int layoutResourceId;
    ArrayList<matchreturned> data = null;
    Activity a;

    public MatchResultAdapter(Context context, int layoutResourceId, ArrayList<matchreturned> data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MatchHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new MatchHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.icon);
            holder.txtTitle = (TextView)row.findViewById(R.id.firstLine);

            row.setTag(holder);
        }
        else
        {
            holder = (MatchHolder)row.getTag();
        }

        matchreturned match = data.get(position);
        holder.txtTitle.setText(match.getUsername());
        holder.imgIcon.setImageResource(context.getResources().getIdentifier(match.getPicture(), "drawable", "com.example.user.hackust2016"));

        return row;
    }

    static class MatchHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }

}