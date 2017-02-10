package com.hazfutbol.hfapp.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;

import java.net.ConnectException;

/**
 * Created by ninosimeon on 09/02/17.
 */

public class Register3Fragment extends Fragment {

    Context myContext;
    EditText txtEmail;
    EditText txtPassword;
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = getActivity().getApplicationContext();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register3, container, false);
        txtEmail = (EditText) view.findViewById(R.id.txtEmail);
        txtPassword = (EditText) view.findViewById(R.id.txtPassword);
        btnNext = (Button) view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getArguments().getString("name");
                String lastName = getArguments().getString("lastName");
                Toast.makeText(myContext, name + lastName,Toast.LENGTH_LONG).show();

                Bundle bundle = getArguments();

                Register4Fragment page4 = new Register4Fragment();
                page4.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_register3, page4);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
