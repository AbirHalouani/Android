package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServiceHolder extends RecyclerView.ViewHolder {
    TextView textView1;
    TextView textView2;
    TextView textView3;

    public ServiceHolder(@NonNull View itemView) {
        super(itemView);
        textView1= itemView.findViewById(R.id.textView1);
        textView2= itemView.findViewById(R.id.textView2);
        textView3= itemView.findViewById(R.id.textView3);
    }
}
