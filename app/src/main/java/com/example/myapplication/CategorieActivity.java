package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.CategorieDB;
import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;


import java.util.List;

public class CategorieActivity extends AppCompatActivity {

    RecyclerView recycleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_holder);
        recycleView = findViewById(R.id.recycleView);


        MyDataBase db = MyDataBase.getDataBase(CategorieActivity.this);
        List<Categorie> categorieList=db.categorieDao().getAll();
        CategorieAdapter adapter =new CategorieAdapter(categorieList);
        adapter.notifyDataSetChanged();
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

    }
}
