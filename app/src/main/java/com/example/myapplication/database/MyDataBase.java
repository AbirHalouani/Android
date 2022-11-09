package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.dao.CategorieDao;
import com.example.myapplication.dao.ServiceDao;
import com.example.myapplication.entity.Categorie;
import com.example.myapplication.entity.Service;
import com.example.myapplication.serviceActivity;

@Database(entities = {Service.class,Categorie.class}, version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    private static MyDataBase instance;



    public abstract ServiceDao serviceDao();
    public abstract CategorieDao categorieDao();

    public static MyDataBase getDataBase(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(), MyDataBase.class, "db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
