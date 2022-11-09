package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.myapplication.entity.Categorie;
import com.example.myapplication.entity.CategorieWithService;
import com.example.myapplication.entity.Service;

import java.util.List;

@Dao
public interface CategorieDao {


    @Insert
    void insertOne(Categorie categorie);
    @Delete
    void delete(Categorie categorie);
    @Query("SELECT * FROM categorie_table")
    List<Categorie> getAll();

    @Transaction
    @Query("SELECT * FROM categorie_table")
    public List<CategorieWithService> getCategorieWithService();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertService(Service service);





}
