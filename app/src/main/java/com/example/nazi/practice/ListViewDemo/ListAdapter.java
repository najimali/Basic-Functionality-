package com.example.nazi.practice.ListViewDemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nazi.practice.ListViewDemo.ListCustomClass;
import com.example.nazi.practice.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Nazi on 12/24/2018.
 */

public class ListAdapter extends ArrayAdapter<ListCustomClass>{
    //private int mColorResourceId;
    public ListAdapter(Activity context, ArrayList<ListCustomClass> word_arrayList)
    {
        super(context,0, (List<ListCustomClass>) word_arrayList);
        //this.mColorResourceId=color;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        }
            ListCustomClass currentWord=getItem(position);
            TextView tv1=listItemView.findViewById(R.id.default_trans);
            TextView tv2=listItemView.findViewById(R.id.miwok_trans);
            CircleImageView circleImageView=listItemView.findViewById(R.id.circleImageView);
            tv1.setText(currentWord.getmDefaultTranslation());
            tv2.setText(currentWord.getmMiWokTranslation());
            circleImageView.setImageResource(currentWord.getmImageResourceId());



        return listItemView;

    }
}
