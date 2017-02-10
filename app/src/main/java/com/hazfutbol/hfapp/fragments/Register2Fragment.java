package com.hazfutbol.hfapp.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hazfutbol.hfapp.R;

/**
 * Created by ninosimeon on 09/02/17.
 */

public class Register2Fragment extends Fragment {
    EditText txtBirthDate;
    RadioGroup rbtnGender;
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register2,container,false);
        txtBirthDate = (EditText) view.findViewById(R.id.txtBirthDate);
        rbtnGender = (RadioGroup) view.findViewById(R.id.rbtnGender);
        btnNext = (Button) view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId= rbtnGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) rbtnGender.findViewById(selectedRadioId);

                int birthDate = Integer.parseInt(txtBirthDate.getText().toString());
                String gender = selectedRadioButton.getText().toString();

                Bundle bundle = getArguments();
                bundle.putInt("age",birthDate);
                bundle.putString("gender", gender);

                Register3Fragment page3 = new Register3Fragment();
                page3.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_register2, page3);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
