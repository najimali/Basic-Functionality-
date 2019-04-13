package com.example.nazi.practice.DataStorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazi.practice.R;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper mydb;
    private EditText editName,editSurname,editMarks;
    Button btn_addData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mydb = new DatabaseHelper(this);
        editName = findViewById(R.id.name_sql);
        editSurname = findViewById(R.id.surname_sql);
        editMarks = findViewById(R.id.marks_sql);
        btn_addData = findViewById(R.id.Add_data_sql);


        AddData();


   }
    public void AddData() {
        final String name = editName.getText().toString().trim();
        final String surname = editSurname.getText().toString().trim();
        final String marks = editMarks.getText().toString().trim();
        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsertedData=mydb.insertData(name,surname,marks);
                if(isInsertedData==true)
                {
                    Toast.makeText(getApplicationContext(),"Data Added ",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Data not added",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
