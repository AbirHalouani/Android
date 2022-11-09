package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import com.example.myapplication.entity.Service;

@Dao
public interface ServiceDao {

    @Insert
    void insertOne(Service service);
    @Delete
    void delete(Service service);
    @Query("SELECT * FROM service_table")
    List<Service> getAll();
}

