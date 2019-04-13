package com.example.nazi.practice.Examples;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nazi.practice.R;

public class Splashscreen extends AppCompatActivity {
    private SharedPreferences preferences;
    private String email="",password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        preferences=getSharedPreferences("mypref",MODE_PRIVATE);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                email=preferences.getString("email","");
                password=preferences.getString("password","");
                if(email!=""&password!="")
                {
                    startActivity((new Intent(Splashscreen.this,GridViewDemo.class)));
                    finish();
                }
                else{
                    startActivity((new Intent(Splashscreen.this,Login.class)));
                    finish();
                }
            }
        },3000);
    }
}
