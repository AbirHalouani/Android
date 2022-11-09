package com.example.myapplication.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;


public class CategorieWithService {
   @Embedded
   public Categorie categorie;
    @Relation(
            parentColumn = "idCategorie",
            entityColumn = "idC"
    )
    public List<Service> serviceList;
}
