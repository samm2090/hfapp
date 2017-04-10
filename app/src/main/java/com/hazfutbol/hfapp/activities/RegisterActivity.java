package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.fragments.Register2Fragment;


public class RegisterActivity extends Activity {

    private Context myContext;
    private EditText txtName;
    private EditText txtLastName;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myContext = getApplicationContext();

        btnNext = (Button) findViewById(R.id.btnNext);
        txtName = (EditText) findViewById(R.id.txtName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String lastName = txtLastName.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("lastName", lastName);

                Register2Fragment page2 = new Register2Fragment();
                page2.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_register, page2);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
    }
}
