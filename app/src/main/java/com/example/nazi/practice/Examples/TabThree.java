package com.example.nazi.practice.Examples;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazi.practice.R;


public class TabThree extends Fragment {
    public static final String ARG_OBJECT = "object";


    public TabThree() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         return inflater.inflate(R.layout.fragment_tab_three, container, false);

    }
}
