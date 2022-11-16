package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;

import java.util.List;

public class CategorieAdapterAdmin extends RecyclerView.Adapter<CategorieHolderAdmin> {

    List<Categorie> categorieList;
    private Context context;

    public CategorieAdapterAdmin(List<Categorie> categorieList , Context c )
    {this.categorieList= categorieList;
    this.context=c ;}

    public CategorieAdapterAdmin(List<Categorie> categorieList)
    {this.categorieList= categorieList;
       }

    @NonNull
    @Override
    public CategorieHolderAdmin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_categorie_item_admin,parent,false);
        context= parent.getContext();

        return new CategorieHolderAdmin(v);
    }



    public void addCategorie(Categorie c) {
        categorieList.add(c);
        notifyItemInserted(categorieList.size() - 1);
    }
    public void removeCategorie(Categorie c) {

    }
  /*  public void UpdateCategorie(Categorie c) {
        categorieList.(c);
        notifyItemRemoved(categorieList.size() + 1);
    }*/


    @Override
    public void onBindViewHolder(@NonNull CategorieHolderAdmin holder, int position) {
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

       holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categorie c = categorieList.get(position);

                MyDataBase db = MyDataBase.getDataBase(view.getContext());
                db.categorieDao().delete(c);
categorieList.remove(holder.getAdapterPosition());
notifyItemRemoved(holder.getAdapterPosition());
            }
        });



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
