package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Service;

public class addService extends AppCompatActivity {

    EditText prix ;
    EditText lieu ;
    EditText date ;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        prix= findViewById(R.id.prix);
        lieu= findViewById(R.id.lieu);
        date = findViewById(R.id.date);
        button2=findViewById(R.id.button2);
        MyDataBase db = MyDataBase.getDataBase(addService.this);
        button2.setOnClickListener(v-> {

        float p= Float.parseFloat(prix.getText().toString());
        String l = lieu.getText().toString();
        Service s = new Service(p,l);
        db.serviceDao().insertOne(s);




        }
    );

}}
