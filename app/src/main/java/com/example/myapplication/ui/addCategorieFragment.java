package com.example.myapplication.ui;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.CategorieAdapter;
import com.example.myapplication.CategorieAdapterAdmin;
import com.example.myapplication.R;
import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addCategorieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addCategorieFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private final int Gallery_REQ_CODE=1000;
    EditText editText ;
    Button button ;
    Button button2 ;
    ImageView bird;
    private static int REQUEST_CODE = 100;
    Uri selectedImageUri;
    RecyclerView recyclerView ;

    OutputStream outputStream;

    public addCategorieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addCategorieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addCategorieFragment newInstance(String param1, String param2) {
        addCategorieFragment fragment = new addCategorieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_addcategorie, container, false);
        button = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button3);
        bird = view.findViewById(R.id.image);
       recyclerView= view.findViewById(R.id.listCategorieAdmin);


        MyDataBase db = MyDataBase.getDataBase(view.getContext());

        List<Categorie> categorieList=db.categorieDao().getAll();
        CategorieAdapterAdmin adapter =new CategorieAdapterAdmin(categorieList);

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        button2.setOnClickListener( new View.OnClickListener() {


            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_GET_CONTENT,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                //intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "select a picture"), Gallery_REQ_CODE);


            }
        });
        editText = view.findViewById(R.id.nomc);

        button.setOnClickListener(v-> {


            String l = editText.getText().toString();
            Categorie c = new Categorie(l,selectedImageUri.toString());

            db.categorieDao().insertOne(c);

            adapter.addCategorie(c);



           /* AppCompatActivity activity = (AppCompatActivity) view.getContext();
            //ConstraintLayout layout = view.findViewById(R.id.layoutAddC);
            //layout.setVisibility(View.INVISIBLE);
            listCategory fragment = new listCategory();
            button.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.layoutAddC,fragment,"listCategorie").addToBackStack(null).commit();*/


        });





        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try { super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Gallery_REQ_CODE) {
            if(resultCode == RESULT_OK) {
                selectedImageUri = data.getData();

                    Bitmap i =MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),selectedImageUri);
                bird.setImageBitmap(i);
            }

            }}catch (IOException e) {
            e.printStackTrace();
        }
        }
    }




