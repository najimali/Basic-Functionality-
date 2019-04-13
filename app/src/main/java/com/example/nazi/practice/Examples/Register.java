package com.example.nazi.practice.Examples;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nazi.practice.R;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private EditText ed1,ed2,ed3,ed4;
    private Button register;
    private SQLiteDatabase db;

    public void registerHere(){
        String name =ed1.getText().toString().trim();
        String email =ed2.getText().toString().trim();
        String password =ed3.getText().toString().trim();
        String city =ed4.getText().toString().trim();

        if(name.isEmpty())ed1.setError("Please Fill the Field");
        else if(email.isEmpty())ed2.setError("Please Fill the Field");
        else if(password.isEmpty())ed3.setError("Please Fill the Field");
        else if(password.length()<8)ed3.setError("Password is too short");
        else if(city.isEmpty())ed4.setError("Please Fill the Field");
        else{
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            try
            {
                adb.setTitle("Alert");
                adb.setIcon(R.drawable.ic_warning_black_24dp);
                db.execSQL("INSERT INTO record(name,email,password,city)" +
                        "VALUES('"+name+"','"+email+"','"+password+"','"+city+"')");
                adb.setMessage("RECORD SAVED SUCCESSFULLY");
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Register.this,Login.class));
                        finish();
                    }
                });
                adb.create().show();

            }catch(SQLiteException ex)
            {
                Log.e("error",ex.getMessage());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db =openOrCreateDatabase("mydb.db",MODE_PRIVATE,null);
        //record is table name
        //data is inserted here
        db.execSQL("CREATE TABLE IF NOT EXISTS record(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "name VARCHAR(50) NOT NULL, email VARCHAR(50) UNIQUE NOT NULL," +
                        "password VARCHAR(50) NOT NULL,city VARCHAR(50) NOT NULL)");


        init();
        register.setOnClickListener(this);
    }

    private void init() {
        ed1 =findViewById(R.id.editName);
        ed2 =findViewById(R.id.editEmail);
        ed3 =findViewById(R.id.editPassword);
        ed4 =findViewById(R.id.editCity);
        register=findViewById(R.id.signUP);
    }
    public void onClick(View v)
    {
        if(v==register)
        {
            registerHere();
        }
    }

}
