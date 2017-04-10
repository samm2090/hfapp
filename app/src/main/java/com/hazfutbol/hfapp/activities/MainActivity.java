package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hazfutbol.hfapp.R;

public class MainActivity extends Activity {

    private Context myContext;
    private Button btnRegister;
    private Button btnFacebookRegister;
    private TextView lblLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myContext = getApplicationContext();
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnFacebookRegister = (Button) findViewById(R.id.btnFacebookRegister);
        lblLogin = (TextView) findViewById(R.id.lblLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myContext, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnFacebookRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myContext, RegisterActivity.class);
                startActivity(intent);
            }
        });

        lblLogin.setMovementMethod(LinkMovementMethod.getInstance());
        lblLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myContext, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}
