package com.example.mariemmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class ReclamationActivity extends AppCompatActivity {
    EditText nom, reclamation;
    Button insert, update, delete, view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);
        nom = findViewById(R.id.nom);
        reclamation = findViewById(R.id.reclamation);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomTXT = nom.getText().toString();
                String reclamationTXT = reclamation.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(nomTXT, reclamationTXT);
                if(checkinsertdata==true)
                    Toast.makeText(ReclamationActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ReclamationActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomTXT = nom.getText().toString();
                String reclamationTXT = reclamation.getText().toString();


                Boolean checkupdatedata = DB.updateuserdata(nomTXT, reclamationTXT);
                if(checkupdatedata==true)
                    Toast.makeText(ReclamationActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ReclamationActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });




        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomTXT = nom.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nomTXT);
                if(checkudeletedata==true)
                    Toast.makeText(ReclamationActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ReclamationActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(ReclamationActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Nom :"+res.getString(0)+"\n");
                    buffer.append("reclamation :"+res.getString(1)+"\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ReclamationActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Les reclamations:");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}