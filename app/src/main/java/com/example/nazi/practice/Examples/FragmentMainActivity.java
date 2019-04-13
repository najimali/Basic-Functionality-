package com.example.nazi.practice.Examples;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nazi.practice.R;

public class FragmentMainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);


    }
    public void ChangeFragments(View view)
    {
        Fragment fragmentObj=null;
          /*
        To manage fragments we need FRagments Manager that help us to handle transaction betweens.
        With transaction we mean a sequence of steos to add,replace or remove fragments.
     */
          if(view==findViewById(R.id.buttonf1))
          {
              FragmentManager fm=getSupportFragmentManager();
              FragmentTransaction ft=fm.beginTransaction();
              fragmentObj=new FragmentOne();
              ft.replace(R.id.fragment_place,fragmentObj);
              ft.commit();
          }
        if(view==findViewById(R.id.buttonf2))
        {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            fragmentObj=new FragmentTwo();
            ft.replace(R.id.fragment_place,fragmentObj);
            ft.commit();
        }
    }
}
