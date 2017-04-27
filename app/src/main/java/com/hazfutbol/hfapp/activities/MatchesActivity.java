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

public class MatchesActivity extends TopBottomBarActivity {

    Button btnMatches;
    Context myContext;
    TextView lblToolbarTitle;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        myContext = getApplicationContext();
        resources = getResources();
        btnMatches = (Button) findViewById(R.id.btnMatches);
        lblToolbarTitle = (TextView) findViewById(R.id.lblToolbarTitle);

        lblToolbarTitle.setText(resources.getText(R.string.matches));

        btnMatches.setOnClickListener(null);
        btnMatches.setBackgroundColor(ContextCompat.getColor(myContext, R.color.hf_green));
        btnMatches.setTextColor(ContextCompat.getColor(myContext, R.color.white));

        Drawable iconStadium = ContextCompat.getDrawable(myContext, R.drawable.icon_stadium);
        iconStadium.setColorFilter(ContextCompat.getColor(myContext, R.color.white), PorterDuff.Mode.SRC_ATOP);
        iconStadium.setBounds(0,0,70,70);

        btnMatches.setCompoundDrawables(null,iconStadium,null,null);
    }
}
