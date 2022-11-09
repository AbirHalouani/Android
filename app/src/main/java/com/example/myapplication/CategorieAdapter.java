package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.entity.Categorie;
import com.example.myapplication.entity.Service;

import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieHolder> {

    List<Categorie> categorieList;

    public CategorieAdapter(List<Categorie> categorieList)
    {this.categorieList= categorieList;}

    @NonNull
    @Override
    public CategorieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_categorie_item,parent,false);

        return new CategorieHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieHolder holder, int position) {
        Categorie c = categorieList.get(position);

        //holder.textView1.setText(s.getIdService());
        holder.textView.setText(c.getNomCategorie());

    }

    @Override
    public int getItemCount() {
        return categorieList.size();
    }
}
