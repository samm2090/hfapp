package com.hazfutbol.hfapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.utils.MyConstants;


public class MainMenuActivity extends ActionBarActivity {

    private Button btnMyTeam;
    private Button btnMatches;
    private Button btnTournaments;
    private TextView lblWelcome;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnMyTeam = (Button) findViewById(R.id.btnMyTeam);
        btnMatches = (Button) findViewById(R.id.btnMatches);
        btnTournaments = (Button) findViewById(R.id.btnTournaments);
        lblWelcome = (TextView) findViewById(R.id.lblWelcome);

        SharedPreferences sharedPreferences =
                getSharedPreferences(MyConstants.USER_INFORMATION, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("user_name", "");

        lblWelcome.setText(Html.fromHtml("Hola, <b>" + username + "</b>"));


        myContext = getApplicationContext();

        btnMyTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, MyTeamActivity.class);
                startActivity(intent);
            }
        });

        btnMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, MatchesActivity.class);
                startActivity(intent);
            }
        });

        btnTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, TournamentsActivity.class);
                startActivity(intent);
            }
        });

    }

}
