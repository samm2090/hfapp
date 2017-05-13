package com.hazfutbol.hfapp.fragments;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.Player;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.utils.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User registration second view
 */
public class Register2Fragment extends Fragment {

    private static final String MALE = "Masculino";
    private Context myContext;
    private Resources myResources;
    private EditText txtBirthDate;
    private RadioGroup rbtnGender;
    private Button btnNext;
    private SimpleDateFormat simpleDateFormat;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private int actualYear;
    private int actualMonth;
    private int actualDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register2, container, false);

        myContext = getActivity().getApplicationContext();
        myResources = myContext.getResources();
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
                datePickerDialog = new DatePickerDialog(getActivity(), android.R.style
                        .Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        txtBirthDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, actualYear, actualMonth, actualDay);

                datePickerDialog.setTitle(myResources.getString(R.string.select_date));
                datePickerDialog.show();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId = rbtnGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) rbtnGender.findViewById(selectedRadioId);
                String gender = selectedRadioButton.getText().toString();

                Date birthDate = null;
                try {
                    birthDate = simpleDateFormat.parse(txtBirthDate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (!(gender.isEmpty() || null == birthDate)) {
                    int genderId = MALE.equals(gender) ? 1 : 2;

                    Player player = new Player();
                    player.setPlayerBirthday(birthDate);
                    player.setPlayerGender(genderId);
                    player.setUserId(2);

                    Bundle bundle = getArguments();
                    bundle.putParcelable(MyConstants.PLAYER, player);

                    Register3Fragment page3 = new Register3Fragment();
                    page3.setArguments(bundle);

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_register2, page3);
                    fragmentTransaction.addToBackStack(null);

                    Utilities.hideSoftKeyboard(getActivity());
                    fragmentTransaction.commit();
                } else {
                    if (null == birthDate) {
                        txtBirthDate.setError(myResources.getString(R.string.birth_date_mandatory));
                    }

                    Toast.makeText(myContext, myResources.getString(R.string
                            .user_register_incomplete2), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
