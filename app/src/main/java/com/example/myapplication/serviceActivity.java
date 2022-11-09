package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Service;

import java.util.List;

public class serviceActivity extends AppCompatActivity {

    RecyclerView recycleView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        recycleView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.searchView);

        MyDataBase db = MyDataBase.getDataBase(serviceActivity.this);
        List<Service> listService=db.serviceDao().getAll();
        ServiceAdapter adapter =new ServiceAdapter(listService);
        //adapter.notifyDataSetChanged();
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }
}