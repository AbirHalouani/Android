package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.dao.CategorieDao;
import com.example.myapplication.entity.Categorie;


@Database(entities = { Categorie.class}, version = 1, exportSchema = false)
    public abstract class CategorieDB extends RoomDatabase  {
    private static CategorieDB instance;
    //public abstract CategorieDao categorieDao();
    public static CategorieDB getDataBase(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(), CategorieDB.class, "db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
