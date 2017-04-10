package com.hazfutbol.hfapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hazfutbol.hfapp.R;


public abstract class TopBottomBarActivity extends ActionBarActivity {

    private BottomNavigationView bottomOptions;
    private Button btnMyTeam;
    private Button btnMatches;
    private Button btnTournaments;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomOptions = (BottomNavigationView) getLayoutInflater().inflate(R.layout.activity_top_bottom_bar, null).findViewById(R.id.bottom_options);

//        btnMyTeam = (Button) bottomOptions.getRootView().findViewById(R.id.btnMyTeam);
//        btnMatches = (Button) bottomOptions.getRootView().findViewById(R.id.btnMatches);
//        btnTournaments = (Button) bottomOptions.getRootView().findViewById(R.id.btnTournaments);
        myContext = getApplicationContext();

        bottomOptions.inflateMenu(R.menu.menu_options);

//        btnMyTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(myContext, MyTeamActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        btnMatches.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(myContext, MatchesActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        btnTournaments.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(myContext, TournamentsActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void setContentView(int layoutResID) {
        FrameLayout frameLayout = (FrameLayout) bottomOptions.getRootView().findViewById(R.id.activity_content);

        getLayoutInflater().inflate(layoutResID, frameLayout);

        super.setContentView(bottomOptions.getRootView());
    }
}


