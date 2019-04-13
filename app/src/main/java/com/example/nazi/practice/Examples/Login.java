package com.example.nazi.practice.Examples;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nazi.practice.R;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText ed1,ed2;
    private Button login,signup;
    private TextView forgot,register;
    private CheckBox remember;
    private SQLiteDatabase db;
    private SharedPreferences preferences;//it is xml file which store data temporarily until unless user clear the data//
    // like cookies in websites
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=openOrCreateDatabase("mydb.db",MODE_PRIVATE,null);
        preferences=getSharedPreferences("mypref",MODE_PRIVATE);

        init();
        login.setOnClickListener(this);
        register.setOnClickListener(this);
      //  signup.setOnClickListener(this);
    }
 public void loginHere(){
     String email = ed1.getText().toString().trim();
     String password = ed2.getText().toString().trim();
     if(email.isEmpty())ed1.setError("Please Fill the Field");
     else if(password.isEmpty())ed2.setError("Please Fill the Field");
     else if(password.length()<8)ed1.setError("password is too short");
     else{
         AlertDialog.Builder adb = new AlertDialog.Builder(this);

         if(remember.isChecked()){
             try{
                 Cursor c= db.rawQuery("SELECT email,password FROM record " +
                         "WHERE email='"+email+"'and password='"+password+"'",null);
                 if(c.moveToFirst())
                 {
                     editor=preferences.edit();
                     adb.setTitle("Alert");
                     adb.setIcon(R.drawable.ic_warning_black_24dp);
                     adb.setMessage("Login Successfull");
                     adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             Intent intent =new Intent(getApplicationContext(),GridViewDemo.class);
                             startActivity(intent);
                         }
                     });
                     adb.create().show();
                     editor.putString("email",email);
                     editor.putString("password",password);
                     editor.commit();
                 }
                 else{
                     Toast.makeText(getApplicationContext(),
                             "try Again",Toast.LENGTH_SHORT).show();
                     c.moveToNext();
                 }

             }catch(SQLiteException ex){
                 Log.e("error",ex.getMessage());
             }
         }
         else{
             try{
                 Cursor c= db.rawQuery("SELECT email,password FROM record " +
                         "WHERE email='"+email+"'and password='"+password+"'",null);
                 if(c.moveToFirst())
                 {
                     adb.setTitle("Alert");
                     adb.setIcon(R.drawable.ic_warning_black_24dp);
                     adb.setMessage("Login Successfull");
                     adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             Intent intent =new Intent(getApplicationContext(),GridViewDemo.class);
                             startActivity(intent);
                         }
                     });
                     adb.create().show();
                 }
                 else{
                     Toast.makeText(getApplicationContext(),
                             "try Again",Toast.LENGTH_SHORT).show();
                     c.moveToNext();
                 }

             }catch(SQLiteException ex){
                 Log.e("error",ex.getMessage());
             }
         }
     }
 }
    public void registerHere() {
        startActivity(new Intent(getApplicationContext(),Register.class));
    }
        public void forgotPass() {

        }

            private void init() {
        ed1 =findViewById(R.id.editEmail);
        ed2 =findViewById(R.id.editPassword);
        login  =findViewById(R.id.signIN);
        remember =findViewById(R.id.rememberme);
        forgot =findViewById(R.id.textForgot);
        register=findViewById(R.id.textRegistor);
          //      signup=findViewById(R.id.textRegistor);
    }

    @Override
    public void onClick(View v) {
        if (v == login) {
        loginHere();
        }
        if (v == register) {
            registerHere();
        }
        if (v == forgot) {
            forgotPass();
        }

        }

    }

