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
        delete.setOnClickListener(v-> {




          /*  adapterAdmin.categorieList.remove(getAdapterPosition());
            adapterAdmin.notifyItemRemoved(getAdapterPosition());*/
           /* Categorie c = new Categorie();
            int id = getAdapterPosition();
            List<Categorie> ll = db.categorieDao().findCategorieByName(textView.getText().toString());
            for(Categorie i : ll) {
                db.categorieDao().delete(i);

            }*/


        });


      /* itemView.setOnClickListener(new View.OnClickListener() {
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
                                    });} */
                // log.d("demo","onclick: item clicked");
          /*  Intent intent = new Intent(rootview.getContext(), serviceActivity.class);
            rootview.getContext().startActivity(intent); */





    }}








