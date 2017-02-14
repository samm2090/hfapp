package com.hazfutbol.hfapp.fragments;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.hazfutbol.hfapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ninosimeon on 09/02/17.
 */

public class Register2Fragment extends Fragment {
    EditText txtBirthDate;
    RadioGroup rbtnGender;
    Button btnNext;
    SimpleDateFormat simpleDateFormat;
    DatePickerDialog datePickerDialog;
    Calendar calendar;
    int actualYear;
    int actualMonth;
    int actualDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register2, container, false);
        txtBirthDate = (EditText) view.findViewById(R.id.txtBirthDate);
        rbtnGender = (RadioGroup) view.findViewById(R.id.rbtnGender);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        calendar = Calendar.getInstance();
        actualYear = calendar.get(Calendar.YEAR);
        actualMonth = calendar.get(Calendar.MONTH);
        actualDay = calendar.get(Calendar.DAY_OF_MONTH);

        rbtnGender.check(R.id.rbtnMale);

        txtBirthDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                datePickerDialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        txtBirthDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, actualYear, actualMonth, actualDay);

                datePickerDialog.setTitle("Seleccionar fecha");
                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.getDatePicker().setSpinnersShown(true);
                datePickerDialog.show();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId = rbtnGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) rbtnGender.findViewById(selectedRadioId);

                Date birthDate = new Date(txtBirthDate.getText().toString());
                String gender = selectedRadioButton.getText().toString();

                Bundle bundle = getArguments();
                bundle.putSerializable("birthDate", birthDate);
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
