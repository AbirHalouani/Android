package com.example.myapplication.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.CategorieActivity;
import com.example.myapplication.CategorieAdapter;
import com.example.myapplication.R;
import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listCategory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recycleView;

  //  SendDataInterface sendDataInterface ;

    public listCategory() {
        // Required empty public constructor
    }

 /*   public interface  SendDataInterface
    {
        public void sendData(String a );
    } */

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment listCategory.
     */
    // TODO: Rename and change types and number of parameters
    public static listCategory newInstance(String param1, String param2) {
        listCategory fragment = new listCategory();
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
        View view = inflater.inflate(R.layout.activity_categorie_holder, container, false);

        recycleView = view.findViewById(R.id.recycleView);


        MyDataBase db = MyDataBase.getDataBase(view.getContext());
        List<Categorie> categorieList=db.categorieDao().getAll();
        CategorieAdapter adapter =new CategorieAdapter(categorieList);
        adapter.notifyDataSetChanged();
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view ;
    }
  /*  @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            sendDataInterface = (SendDataInterface) activity;
        }catch (RuntimeException a )
        {
            throw new RuntimeException(activity.toString()+"***");
        }
    }*/
}