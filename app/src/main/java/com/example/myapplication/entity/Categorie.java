package com.example.myapplication.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;


@Entity(tableName = "categorie_table")
public class Categorie {
    @PrimaryKey(autoGenerate = true)
    private int idCategorie ;
    @ColumnInfo(name = "nom")
    private String nomCategorie ;

    @ColumnInfo(name = "image")
    private String image ;

    public Categorie(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Categorie(String nomCategorie,String image) {
        this.nomCategorie = nomCategorie;
        this.image = image;
    }
    public Categorie(){}

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
