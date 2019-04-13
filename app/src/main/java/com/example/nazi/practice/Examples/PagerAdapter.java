package com.example.nazi.practice.Examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Nazi on 2/8/2019.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    //int noOfTabs;
    public PagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                TabOne tab1=new TabOne();
                return tab1;
            case 1:
                TabTwo tab2=new TabTwo();
                return tab2;
            case 2:
                TabThree tab3=new TabThree();
                return tab3;
            default:
                    return null;
        }




    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {   switch (position)
       {
           case 0:
               return "Tab One";
           case 1:
               return "Tab two";
           case 2:
               return "Tab three";
       }
        //return "Object" +(position+1);
        return null;
    }
}
