package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;
import com.example.myapplication.ui.serviceFragment;
import com.example.myapplication.ui.updateCategorieFragment;

import java.util.List;


public class CategorieHolderAdmin extends RecyclerView.ViewHolder {
    TextView textView;

    ImageView image ;
    Button edit ;
    Button delete ;
   private  CategorieAdapterAdmin adapterAdmin;

    public CategorieHolderAdmin(@NonNull View itemView ) {
        super(itemView);
        textView= itemView.findViewById(R.id.textViewad);
        image=itemView.findViewById(R.id.imageView7ad);
        edit = itemView.findViewById(R.id.button4);
        delete= itemView.findViewById(R.id.button5);

        MyDataBase db = MyDataBase.getDataBase(itemView.getContext());



       itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString( "update" , textView.getText().toString() );
                                            //textView.getText().toString()
                                            // set Fragment class Arguments

                                            AppCompatActivity activity = (AppCompatActivity) view.getContext();
                                            updateCategorieFragment fragment = new updateCategorieFragment();
                                            fragment.setArguments(bundle);
                                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.layoutAddC,fragment,"updateC").addToBackStack(null).commit();

                                        }
                                    });}
                // log.d("demo","onclick: item clicked");
          /*  Intent intent = new Intent(rootview.getContext(), serviceActivity.class);
            rootview.getContext().startActivity(intent); */





    }








