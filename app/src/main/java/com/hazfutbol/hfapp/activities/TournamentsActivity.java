package com.hazfutbol.hfapp.activities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.TextView;

import com.hazfutbol.hfapp.R;

public class TournamentsActivity extends TopBottomBarActivity {

    private Button btnTournaments;
    private Context myContext;
    private TextView lblToolbarTitle;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournaments);

        myContext = getApplicationContext();
        resources = getResources();
        btnTournaments = (Button) findViewById(R.id.btnTournaments);
        lblToolbarTitle = (TextView) findViewById(R.id.lblToolbarTitle);

        lblToolbarTitle.setText(resources.getText(R.string.tournaments));

        btnTournaments.setOnClickListener(null);
        btnTournaments.setBackgroundColor(ContextCompat.getColor(myContext, R.color.hf_blue));
        btnTournaments.setTextColor(ContextCompat.getColor(myContext, R.color.white));

        Drawable iconTrophy = ContextCompat.getDrawable(myContext, R.drawable.icon_trophy);
        iconTrophy.setColorFilter(ContextCompat.getColor(myContext, R.color.white), PorterDuff.Mode.SRC_ATOP);
        iconTrophy.setBounds(0, 0, 70, 70);

        btnTournaments.setCompoundDrawables(null, iconTrophy, null, null);
    }
}
