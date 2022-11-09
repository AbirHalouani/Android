package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategorieHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public CategorieHolder(@NonNull View itemView) {
        super(itemView);
        textView= itemView.findViewById(R.id.textView);
    }


}