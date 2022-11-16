package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;

public class addCategorie extends AppCompatActivity {
    EditText editText ;
    Button button ;
    Button button2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addcategorie);
        button = findViewById(R.id.button);

       editText = findViewById(R.id.nomc);
        MyDataBase db = MyDataBase.getDataBase(addCategorie.this);
        button.setOnClickListener(v-> {


            String l = editText.getText().toString();
            Categorie c = new Categorie(l);
            db.categorieDao().insertOne(c);
        });
    }
}