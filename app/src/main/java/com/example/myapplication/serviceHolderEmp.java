package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.ui.UpdateServiceFragment;
import com.example.myapplication.ui.updateCategorieFragment;

public class serviceHolderEmp extends RecyclerView.ViewHolder {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView t;
    Button b ;

    public serviceHolderEmp(@NonNull View itemView) {
        super(itemView);
        textView1= itemView.findViewById(R.id.user);
        textView2= itemView.findViewById(R.id.lieu2);
        textView3= itemView.findViewById(R.id.prix2);
        textView3= itemView.findViewById(R.id.prix2);
        b= itemView.findViewById(R.id.button4);
        t= itemView.findViewById(R.id.textView6);


        MyDataBase db = MyDataBase.getDataBase(itemView.getContext());



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString( "updateService" , t.getText().toString() );
                //textView.getText().toString()
                // set Fragment class Arguments

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                UpdateServiceFragment fragment = new UpdateServiceFragment();
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.addservicelayout,fragment,"updateC").addToBackStack(null).commit();

            }
        });}
    // log.d("demo","onclick: item clicked");
          /*  Intent intent = new Intent(rootview.getContext(), serviceActivity.class);
            rootview.getContext().startActivity(intent); */



}


}