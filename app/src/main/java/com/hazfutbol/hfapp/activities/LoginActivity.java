package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.webServices.UserService;

import java.io.IOException;

public class LoginActivity extends Activity {

    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView lblForgotPassword;
    private User user;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myContext = getApplicationContext();
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        lblForgotPassword = (TextView) findViewById(R.id.lblForgotPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                new LoginActivity.LoginAsyncTask().execute(username, password);
            }
        });

        lblForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private class LoginAsyncTask extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            Boolean result = false;
            UserService userService = new UserService();

            try {
                user = userService.login(params[0], params[1]);
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if (result) {
                if (user != null) {
                    Intent intent = new Intent(myContext, MainMenuActivity.class);
                    SharedPreferences sharedPreferences =
                            getSharedPreferences(MyConstants.USER_INFORMATION, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.putString("user_name", user.getUserName().trim());
                    editor.putString("user_lastname", user.getUserLastName());
                    editor.putInt("user_id", user.getUserId());
                    editor.putInt("user_status", user.getUserStatus());
                    editor.putString("user_email", user.getUserEmail());
                    editor.commit();

                    startActivity(intent);
                } else {
                    Toast.makeText(myContext, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(myContext, "Error. Vuelva a intentar", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
