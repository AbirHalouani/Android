package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

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


    @Update
    void update(Categorie categorie);

    @Transaction
    @Query("SELECT * FROM categorie_table")
    public List<CategorieWithService> getCategorieWithService();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertService(Service service);
     @Query("SELECT * FROM categorie_table WHERE nomCategorie = :name")
    Categorie findidCategorieByID(String name);

   // @Query("SELECT idCategorie FROM categorie_table WHERE nom = :name")
    //int findidCategorieByName(String name);


   // @Query("SELECT * FROM categorie_table WHERE nom = :name")
   // List<Categorie> findCategorieByName (String name);





}
