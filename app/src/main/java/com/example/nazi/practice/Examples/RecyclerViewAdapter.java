package com.example.nazi.practice.Examples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazi.practice.R;

import java.util.List;

/**
 * Created by Nazi on 3/5/2019.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<RecyclerViewClass> mListnerList;
    Context context;
    LayoutInflater inflater;

    public RecyclerViewAdapter(List<RecyclerViewClass> mListnerList) {
        this.mListnerList = mListnerList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_title;
        ImageView img;
        TextView tv_subtitle;
        public MyViewHolder(View view)
        {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.default_trans);
            tv_subtitle = (TextView) view.findViewById(R.id.miwok_trans);
            img = (ImageView) view.findViewById(R.id.circleImageView);

        }
    }
    @NonNull
    @Override


    public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list,parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecyclerViewClass currentClass = mListnerList.get(position);
        holder.tv_title.setText(currentClass.getmLangName());
        holder.tv_subtitle.setText(currentClass.getmRoomName());
        holder.img.setImageResource(currentClass.getImage());
    }

    @Override
    public int getItemCount() {
        return mListnerList.size();
    }
}
