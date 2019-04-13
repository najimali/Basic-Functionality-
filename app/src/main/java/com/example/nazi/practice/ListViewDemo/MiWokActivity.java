package com.example.nazi.practice.ListViewDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.nazi.practice.R;

import java.util.ArrayList;

public class MiWokActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        ArrayList<ListCustomClass> word_arrayList= new ArrayList<>();
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.ninja));
        //ListCustomClass accepting three paramter bcoz we have define two string and image object in the ListCustomClass.
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.in_love));
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.happy));
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.smart));
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.smart));
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.tongue_out));
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.suspicious));
        word_arrayList.add(new ListCustomClass("one","lutti",R.drawable.bored));

        listView=findViewById(R.id.listView);
        ListAdapter adapter=new ListAdapter(this,word_arrayList);
        listView.setAdapter(adapter);



    }
}
