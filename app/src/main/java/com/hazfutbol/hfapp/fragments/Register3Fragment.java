package com.hazfutbol.hfapp.fragments;

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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.utils.Utilities;

import java.net.ConnectException;

/**
 * User registration third view
 */
public class Register3Fragment extends Fragment {

    private Context myContext;
    private Resources myResources;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register3, container, false);

        myContext = getActivity().getApplicationContext();
        myResources = myContext.getResources();
        txtEmail = (EditText) view.findViewById(R.id.txtEmail);
        txtPassword = (EditText) view.findViewById(R.id.txtPassword);
        btnNext = (Button) view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if (!(email.isEmpty() || password.isEmpty())) {
                    Bundle bundle = getArguments();
                    User user = bundle.getParcelable(MyConstants.USER);
                    user.setUserEmail(email);
                    user.setUserPassword(password);
                    bundle.putParcelable(MyConstants.USER, user);

                    Register4Fragment page4 = new Register4Fragment();
                    page4.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_register3, page4);
                    fragmentTransaction.addToBackStack(null);

                    Utilities.hideSoftKeyboard(getActivity());
                    fragmentTransaction.commit();
                } else {
                    if (email.isEmpty()) {
                        txtEmail.setError(myResources.getString(R.string.email_mandatory));
                    }
                    if (password.isEmpty()) {
                        txtPassword.setError(myResources.getString(R.string.password_mandatory));
                    }
                    Toast.makeText(myContext, myResources.getString(R.string
                            .user_register_incomplete3), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
