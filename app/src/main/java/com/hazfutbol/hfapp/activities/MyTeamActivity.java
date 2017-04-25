package com.hazfutbol.hfapp.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.fragments.CreateTeamFragment;

public class MyTeamActivity extends TopBottomBarActivity {

    private Button btnMyTeam;
    private Button btnCreateTeam;
    private Context myContext;
    private TextView lblToolbarTitle;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_team);

        myContext = getApplicationContext();
        resources = getResources();
        btnMyTeam = (Button) findViewById(R.id.btnMyTeam);
        lblToolbarTitle = (TextView) findViewById(R.id.lblToolbarTitle);
        btnCreateTeam = (Button) findViewById(R.id.btnCreateTeam);

        lblToolbarTitle.setText(resources.getText(R.string.my_team));

        Drawable iconHeart = ContextCompat.getDrawable(myContext, R.drawable.icon_heart);
        iconHeart.setColorFilter(ContextCompat.getColor(myContext, R.color.white), PorterDuff.Mode.SRC_ATOP);
        iconHeart.setBounds(0,0,60,60);

        btnMyTeam.setOnClickListener(null);
        btnMyTeam.setBackgroundColor(ContextCompat.getColor(myContext, R.color.hf_pink));
        btnMyTeam.setTextColor(ContextCompat.getColor(myContext, R.color.white));
        btnMyTeam.setCompoundDrawables(null,iconHeart,null,null);

        btnCreateTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTeamFragment createTeamFragment = new CreateTeamFragment();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_my_team, createTeamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
