package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.entity.Categorie;
import com.example.myapplication.entity.Service;

import java.io.IOException;
import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieHolder> {

    List<Categorie> categorieList;
    private Context context;

    public CategorieAdapter(List<Categorie> categorieList , Context c )
    {this.categorieList= categorieList;
    this.context=c ;}

    public CategorieAdapter(List<Categorie> categorieList)
    {this.categorieList= categorieList;
       }

    @NonNull
    @Override
    public CategorieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_categorie_item,parent,false);
        context= parent.getContext();

        return new CategorieHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieHolder holder, int position) {
      int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        /*if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                  MainActivity  , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);}
else{

        try {*/
            Categorie c = categorieList.get(position);
          //  holder.textView1.setText(s.getIdService());
        holder.textView.setText(c.getNomCategorie());
        holder.image.setImageURI (Uri.parse(c.getImage()));
      /*  } catch (IOException e) {
            e.printStackTrace();
        } }*/


    }

    @Override
    public int getItemCount() {
        return categorieList.size();
    }

    private void checkPermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                new Activity()   , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);

    }}

}
