package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.ui.serviceFragment;


public class CategorieHolder extends RecyclerView.ViewHolder {
    TextView textView;

    ImageView image ;

    public CategorieHolder(@NonNull View itemView) {
        super(itemView);
        textView= itemView.findViewById(R.id.textView);
        image=itemView.findViewById(R.id.imageView7);


        itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString( "fromHolder" , textView.getText().toString() );
                                            //textView.getText().toString()
                                            // set Fragment class Arguments

                                            AppCompatActivity activity = (AppCompatActivity) view.getContext();
                                            serviceFragment fragment = new serviceFragment();
                                            fragment.setArguments(bundle);
                                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.holder,fragment,"service").addToBackStack(null).commit();
                                        }
                                    });}
                // log.d("demo","onclick: item clicked");
          /*  Intent intent = new Intent(rootview.getContext(), serviceActivity.class);
            rootview.getContext().startActivity(intent); */







    }







