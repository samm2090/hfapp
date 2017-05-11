package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.fragments.Register2Fragment;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;

/**
 * User registration first view
 */
public class RegisterActivity extends Activity {

    private Context myContext;
    private Resources myResources;
    private EditText txtName;
    private EditText txtLastName;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myContext = getApplicationContext();
        myResources = myContext.getResources();
        btnNext = (Button) findViewById(R.id.btnNext);
        txtName = (EditText) findViewById(R.id.txtName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtName.getText().toString();
                String userLastName = txtLastName.getText().toString();

                if (!(userName.isEmpty() || userLastName.isEmpty())) {
                    User user = new User();
                    user.setUserName(userName);
                    user.setUserLastName(userLastName);

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MyConstants.USER, user);

                    Register2Fragment page2 = new Register2Fragment();
                    page2.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.activity_register, page2);
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();
                } else {
                    if(userName.isEmpty()){
                        txtName.setError(myResources.getString(R.string.name_mandatory));
                    }

                    if(userLastName.isEmpty()){
                        txtLastName.setError(myResources.getString(R.string.last_name_mandatory));
                    }

                    Toast.makeText(myContext, myResources.getString(R.string
                            .user_register_incomplete1), Toast
                            .LENGTH_SHORT).show();
                }
            }
        });
    }
}