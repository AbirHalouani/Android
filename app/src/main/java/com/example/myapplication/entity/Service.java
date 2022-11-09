package com.example.myapplication.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "service_table")
public class Service {
    @PrimaryKey(autoGenerate = true)
    private int idService ;
    @ColumnInfo(name = "price")
    private float price ;
    @ColumnInfo(name = "location")
    private String location ;

    public int idC ;

    public Service() {
    }

    public Service(int idService, float price, String location) {
        this.idService = idService;
        this.price = price;
        this.location = location;
    }

    public Service( float price, String location) {
        this.price = price;
        this.location = location;
    }
    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
