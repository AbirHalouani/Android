package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ServiceHolder;
import com.example.myapplication.entity.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceHolder> {

    List<Service> serviceList;
    ServiceAdapter(List<Service> list){
        this.serviceList=list;
    }
    @NonNull
    @Override
    public ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.serviceitem,parent,false);
        return new ServiceHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceHolder holder, int position) {
        Service s = serviceList.get(position);
        //holder.textView1.setText(s.getIdService());
        holder.textView2.setText(String.valueOf(s.getPrice())+"DT");
        holder.textView3.setText(s.getLocation());

    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }
}
