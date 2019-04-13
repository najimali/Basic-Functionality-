package com.example.nazi.practice.Examples;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.nazi.practice.R;

public class GridViewDemo extends AppCompatActivity {
    private GridView gridView;
    private GridAdapter adapter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    public String [] versions;
    public Integer[] images ={
            R.drawable.bored,
            R.drawable.in_love,
            R.drawable.ninja,
            R.drawable.smart,
            R.drawable.suspicious,
            R.drawable.tongue_out,
            R.drawable.happy


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);
        preferences=getSharedPreferences("mypref",MODE_PRIVATE);

        versions = getResources().getStringArray(R.array.versions);
        gridView = findViewById(R.id.gridview);
        adapter = new GridAdapter(GridViewDemo.this, images, versions);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(GridViewDemo.this, "" + versions[position], Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* if(item.getItemId()==R.id.logout);
        {
            editor=preferences.edit();
            editor.clear().commit();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }*/
        return true;
    }
}
