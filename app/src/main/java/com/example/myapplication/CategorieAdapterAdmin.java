package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;

import java.util.List;

public class CategorieAdapterAdmin extends RecyclerView.Adapter<CategorieHolderAdmin> {

    List<Categorie> categorieList;
    private Context context;
    //Dialog dialog = new Dialog(context);
    //private Fragment f ;



    public CategorieAdapterAdmin(List<Categorie> categorieList , Context c )
    {this.categorieList= categorieList;
   // this.context=c ;

    }

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

        notifyItemInserted(categorieList.size());
    }
    public void removeCategorie(Categorie c) {

    }
   public void UpdateCategorie(Categorie c) {
      int   i=categorieList.indexOf(c)+1;
       categorieList.set(i,c);
       notifyItemChanged(i);


    }


    @Override
    public void onBindViewHolder(@NonNull CategorieHolderAdmin holder, int position) {
   //   int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);


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

                categorieList.remove(position);
                notifyItemRemoved(position);
                db.categorieDao().delete(c);
            }
        });

        /*holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





              /*  dialog.setContentView(R.layout.fragment_update_categorie);
                EditText editText ;
                Button button ;
                Button button2 ;
                ImageView bird;

                int Gallery_REQ_CODE=1000;
                Uri selectedImageUri;


                button = dialog.findViewById(R.id.buttonup);
                button2 =  dialog.findViewById(R.id.button3up);
                bird =  dialog.findViewById(R.id.imageup);


                String nomC=""; String image="";

if(!holder.textView.getText().equals(""))
{}
else
{
    Toast.makeText(context, "Saisir nom Categorie", Toast.LENGTH_SHORT).show();
}
                if(!holder.image.equals(null))
                {
                                    }
                else
                {
                    Toast.makeText(context, "choisit image ", Toast.LENGTH_SHORT).show();
                }


*/

               /* categorieList.set(position,new Categorie(nomC,image));
                Categorie c = categorieList.get(position);
               MyDataBase db = MyDataBase.getDataBase(view.getContext());
                c.setNomCategorie(nomC);
                c.setImage(image);
                db.categorieDao().update(c);
                categorieList.set(position,new Categorie(nomC,image));
                notifyItemChanged(position);*/
              //  dialog.dismiss();


         /*   }


        });*/

       // dialog.show();











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
