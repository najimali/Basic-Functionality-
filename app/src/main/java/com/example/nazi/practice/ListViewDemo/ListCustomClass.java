package com.example.nazi.practice.ListViewDemo;

/**
 * Created by Nazi on 12/24/2018.
 */

public class ListCustomClass {
    private String mDefaultTranslation;
    private String mMiWokTranslation;
    private int mImageResourceId;
    public ListCustomClass(String defaultTranslation,String miWokTranslation,int imageResourceId)
    {
        this.mDefaultTranslation=defaultTranslation;
        this.mMiWokTranslation=miWokTranslation;
        this.mImageResourceId=imageResourceId;

    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmMiWokTranslation() {
        return mMiWokTranslation;
    }
}
