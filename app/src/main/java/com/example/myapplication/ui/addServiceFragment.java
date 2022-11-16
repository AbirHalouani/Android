package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.addService;
import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;
import com.example.myapplication.entity.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addServiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText prix ;
    EditText lieu ;
    EditText date ;
    Button button2;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter ;
    List<String> c = new ArrayList<String>();


    public addServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addServiceFragment newInstance(String param1, String param2) {
        addServiceFragment fragment = new addServiceFragment();
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
        View view =inflater.inflate(R.layout.activity_add_service, container, false);
        prix= view.findViewById(R.id.prix);
        lieu= view.findViewById(R.id.lieu);
        date = view.findViewById(R.id.date);
        button2= view.findViewById(R.id.button2);
        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView3);
        MyDataBase db = MyDataBase.getDataBase(view.getContext());
        List<Categorie> categorieList = db.categorieDao().getAll();
        for (Categorie i: categorieList) {
           c.add( i.getNomCategorie());

        }

        arrayAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.listcategorie,c);

        autoCompleteTextView.setAdapter(arrayAdapter);
        button2.setOnClickListener(v-> {

            float p= Float.parseFloat(prix.getText().toString());
            String l = lieu.getText().toString();
           int categorie = db.categorieDao().findidCategorieByName(autoCompleteTextView.getText().toString());
            Service s = new Service(p,l);
            s.idC = categorie ;
            //db.serviceDao().insertOne(s);
            db.categorieDao().insertService(s);



        });
        return view ;
    }
}