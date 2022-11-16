package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ReclamationActivity;
import com.example.myapplication.database.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginActivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText username, password;
    Button btnlogin;
    DBHelper DB;
    public LoginActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginActivity newInstance(String param1, String param2) {
        LoginActivity fragment = new LoginActivity();
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
        View view =  inflater.inflate(R.layout.activity_login, container, false);
        //view.setContentView(R.layout.activity_login);
        username = view.findViewById(R.id.username1);
        password =  view.findViewById(R.id.password1);
        btnlogin =  view.findViewById(R.id.btnsignin1);
        DB = new DBHelper(getContext());
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(getContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(getContext(), "Sign in successfull", Toast.LENGTH_SHORT).show();
                        //Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
                        Intent intent  = new Intent(getContext(), ReclamationActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view ;
    }



}