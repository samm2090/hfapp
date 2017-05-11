package com.hazfutbol.hfapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.adapter.TeamListAdapter;
import com.hazfutbol.hfapp.fragments.CreateTeamFragment;
import com.hazfutbol.hfapp.models.Team;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.webServices.TeamService;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTeamActivity extends TopBottomBarActivity {

    private Button btnMyTeam;
    private Button btnMatches;
    private Button tbnTournaments;
    private Button btnCreateTeam;
    private Context myContext;
    private TextView lblToolbarTitle;
    private Resources resources;
    private RecyclerView rvMyTeams;
    private List<Team> teams;
    private TeamListAdapter teamListAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_team);

        SharedPreferences sharedPreferences =
                getSharedPreferences(MyConstants.USER_INFORMATION, Context.MODE_PRIVATE);
        userId = sharedPreferences.getInt("user_id", 0);

        myContext = getApplicationContext();
        resources = getResources();
        btnMyTeam = (Button) findViewById(R.id.btnMyTeam);
        btnMatches = (Button) findViewById(R.id.btnMatches);
        tbnTournaments = (Button) findViewById(R.id.btnTournaments);
        lblToolbarTitle = (TextView) findViewById(R.id.lblToolbarTitle);
        btnCreateTeam = (Button) findViewById(R.id.btnCreateTeam);
        rvMyTeams = (RecyclerView) findViewById(R.id.rvMyTeams);
        teams = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        lblToolbarTitle.setText(resources.getText(R.string.my_team));

        rvMyTeams.setLayoutManager(layoutManager);

        Drawable iconHeart = ContextCompat.getDrawable(myContext, R.drawable.icon_heart);
        iconHeart.setColorFilter(ContextCompat.getColor(myContext, R.color.white), PorterDuff.Mode.SRC_ATOP);
        iconHeart.setBounds(0, 0, 70, 70);

        btnMyTeam.setOnClickListener(null);
        btnMyTeam.setBackgroundColor(ContextCompat.getColor(myContext, R.color.hf_pink));
        btnMyTeam.setTextColor(ContextCompat.getColor(myContext, R.color.white));
        btnMyTeam.setCompoundDrawables(null, iconHeart, null, null);

        btnCreateTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTeamFragment createTeamFragment = new CreateTeamFragment();

                v.setVisibility(View.GONE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_my_team, createTeamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        new MyTeamActivity.TeamsAsyncTask().execute();
    }

    private class TeamsAsyncTask extends AsyncTask<Void, String, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            Boolean result = false;

            TeamService teamService = new TeamService();

            try {
                teams = teamService.listTeamsByUser(userId);
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            teamListAdapter = new TeamListAdapter(myContext, teams);
            rvMyTeams.setAdapter(teamListAdapter);
        }
    }
}