package com.example.nazi.practice.Earthquake;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nazi.practice.R;

import java.util.ArrayList;

/**
 * Created by Nazi on 12/25/2018.
 */

public class EarthAdapter extends ArrayAdapter<EarthCustomClass>{


    public EarthAdapter( Activity context,ArrayList<EarthCustomClass> arrayList_earthq)
    {
        super(context,0,arrayList_earthq);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_earthquake,parent, false);
        }
        EarthCustomClass currentEarthquake=getItem(position);

        //EarthCustomClass currentClass=getItem(position);
        TextView magnitude=convertView.findViewById(R.id.magnitude_eq);
        magnitude.setText(currentEarthquake.getmMagnitude());
        TextView location=convertView.findViewById(R.id.location_eq);
        location.setText(currentEarthquake.getmLocation());

        TextView date=convertView.findViewById(R.id.date_eq);
        date.setText(currentEarthquake.getmDate());

        return convertView;

    }



}
