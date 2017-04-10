package com.hazfutbol.hfapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hazfutbol.hfapp.R;


public class MainMenuActivity extends ActionBarActivity {

    private Button btnMyTeam;
    private Button btnMatches;
    private Button btnTournaments;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnMyTeam = (Button) findViewById(R.id.btnMyTeam);
        btnMatches = (Button) findViewById(R.id.btnMatches);
        btnTournaments = (Button) findViewById(R.id.btnTournaments);
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
