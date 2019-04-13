package com.example.nazi.practice.Examples;

/**
 * Created by Nazi on 12/24/2018.
 */

public class RecyclerViewClass {
    private String mLangName;
    private int image;
    private String mRoomName;
    public RecyclerViewClass(String langName, String roomName,int image)
    {
       this.mLangName=langName;
        this.mRoomName=roomName;
        this.image=image;


    }

    public String getmRoomName() {
        return mRoomName;
    }

    public String getmLangName() {
        return mLangName;
    }

    public int getImage() {
        return image;
    }
}
