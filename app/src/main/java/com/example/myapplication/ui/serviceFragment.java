package com.example.myapplication.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.myapplication.R;
import com.example.myapplication.ServiceAdapter;
import com.example.myapplication.database.MyDataBase;
import com.example.myapplication.entity.Categorie;
import com.example.myapplication.entity.Service;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link serviceFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class serviceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment serviceFragment.
     */
    // TODO: Rename and change types and number of parameters
    RecyclerView recycleView;
    SearchView searchView;
    public static serviceFragment newInstance(String param1, String param2) {
        serviceFragment fragment = new serviceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public serviceFragment() {
        // Required empty public constructor
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
       View view=  inflater.inflate(R.layout.activity_service, container, false);
        recycleView = view.findViewById(R.id.recycleView);
        searchView = view.findViewById(R.id.searchView);

        MyDataBase db = MyDataBase.getDataBase(view.getContext());

        if (getArguments() != null) {

         String nomcategorie = this.getArguments().getString("fromHolder");
      //  Categorie c = db.categorieDao().findidCategorieByID(nomcategorie);
        List<Service> ll = db.serviceDao().getServiceByCategorie(nomcategorie);
        /*List<Service> listService=db.serviceDao().getAll();
            ServiceAdapter adapter =new ServiceAdapter(listService);*/
        ServiceAdapter adapter =new ServiceAdapter(ll);

        adapter.notifyDataSetChanged();
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));}
        return view ;
    }

}