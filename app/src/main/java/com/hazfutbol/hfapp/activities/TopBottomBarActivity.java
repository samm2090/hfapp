package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hazfutbol.hfapp.R;


public abstract class TopBottomBarActivity extends Activity {

    private Button btnMyTeam;
    private Button btnMatches;
    private Button btnTournaments;
    private Button btnMenuBurger;
    private DrawerLayout drawerLayout;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myContext = getApplicationContext();
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_top_bottom_bar, null);
        btnMenuBurger = (Button) drawerLayout.getRootView().findViewById(R.id.btnMenuBurger);
        btnMyTeam = (Button) drawerLayout.getRootView().findViewById(R.id.btnMyTeam);
        btnMatches = (Button) drawerLayout.getRootView().findViewById(R.id.btnMatches);
        btnTournaments = (Button) drawerLayout.findViewById(R.id.btnTournaments);

        btnMenuBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

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

    @Override
    public void setContentView(int layoutResID) {
        FrameLayout frameLayout = (FrameLayout) drawerLayout.findViewById(R.id.activity_content);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);

        super.setContentView(drawerLayout);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(myContext, MainMenuActivity.class);
        startActivity(intent);
    }
}


