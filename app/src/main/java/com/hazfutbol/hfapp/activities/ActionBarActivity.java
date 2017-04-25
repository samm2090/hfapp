package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hazfutbol.hfapp.R;

public abstract class ActionBarActivity extends Activity {

    private Button btnMenuBurger;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_action_bar, null);

        btnMenuBurger = (Button) drawerLayout.findViewById(R.id.btnMenuBurger);

        btnMenuBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

    @Override
    public void setContentView(int layoutResID) {
        FrameLayout frameLayout = (FrameLayout) drawerLayout.findViewById(R.id.activity_content);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);

        super.setContentView(drawerLayout);
    }
}
