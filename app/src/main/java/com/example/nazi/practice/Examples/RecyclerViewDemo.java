package com.example.nazi.practice.Examples;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nazi.practice.ListViewDemo.ListCustomClass;
import com.example.nazi.practice.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemo extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        List<RecyclerViewClass> recyclerView_arrayList=new ArrayList<>();
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.in_love));
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.happy));
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.smart));
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.smart));
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.tongue_out));
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.suspicious));
        recyclerView_arrayList.add(new RecyclerViewClass("one","lutti",R.drawable.bored));
        recyclerView =findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(recyclerView_arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }

}
