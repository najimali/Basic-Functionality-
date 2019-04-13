package com.example.nazi.practice.Examples;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nazi.practice.Earthquake.EarthQuakeActivity;
import com.example.nazi.practice.ListViewDemo.MiWokActivity;
import com.example.nazi.practice.R;
import com.example.nazi.practice.Soonami.Tsunami;

public class SpinnerDemo extends AppCompatActivity {
    private Spinner spinner;
    private String[] All_App;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        spinner=findViewById(R.id.spinner_id);
        All_App=getResources().getStringArray(R.array.All_App);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,All_App);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                int i=position;
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item+" position is "+i, Toast.LENGTH_LONG).show();

                if(position==1)
                {
                    Intent intent=new Intent(SpinnerDemo.this, EarthQuakeActivity.class);
                    startActivity(intent);
                }
                else if(position==2)
                {
                    Intent intent=new Intent(SpinnerDemo.this, Tsunami.class);
                    startActivity(intent);
                }
                else if(position==3)
                {
                    Intent intent=new Intent(SpinnerDemo.this,MiWokActivity.class);
                    startActivity(intent);
                }
                else if(position==4)
                {
                    Intent intent=new Intent(SpinnerDemo.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(position==5)
                {
                    Intent intent=new Intent(SpinnerDemo.this,FragmentMainActivity.class);
                    startActivity(intent);
                }
                else if(position==6)
                {
                    Intent intent=new Intent(SpinnerDemo.this, AsyncTaskEx.class);
                    startActivity(intent);
                }
                if(position==7)
                {
                    Intent intent=new Intent(SpinnerDemo.this,GridViewDemo.class);
                    startActivity(intent);

                }
                else if(position==8)
                {
                    Intent intent=new Intent(SpinnerDemo.this,ALertDialogDemo.class);
                    startActivity(intent);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
