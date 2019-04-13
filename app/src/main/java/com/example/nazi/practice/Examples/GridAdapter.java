package com.example.nazi.practice.Examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazi.practice.R;

import java.util.zip.Inflater;

/**
 * Created by Nazi on 7/12/2018.
 */

public class GridAdapter extends BaseAdapter {
    Context context;
    private String[] versions;
    private Integer[] images;
   //creating constructor
    public GridAdapter(Context context, Integer[] images, String[] versions) {
        this.context=context;
        this.versions=versions;
        this.images=images;
    }

    @Override
    public int getCount() {
        return versions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.single_item,parent,false);
        ImageView imageView=view.findViewById(R.id.imageview);
        TextView textView=view.findViewById(R.id.textview);
        imageView.setImageResource(images[position]);
        textView.setText(versions[position]);
        return view;
    }
}
