package com.hazfutbol.hfapp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hazfutbol.hfapp.fragments.TeamPhotosFragment;
import com.hazfutbol.hfapp.fragments.TeamPlayersFragment;
import com.hazfutbol.hfapp.fragments.TeamWallFragment;

public class TeamPagerAdapter extends FragmentStatePagerAdapter {

    int tabs;

    public TeamPagerAdapter(FragmentManager fragmentManager, int tabs){
        super(fragmentManager);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                TeamWallFragment teamWallFragment = new TeamWallFragment();
                return teamWallFragment;
            case 1:
                TeamPlayersFragment teamPlayersFragment = new TeamPlayersFragment();
                return teamPlayersFragment;
            case 2:
                TeamPhotosFragment teamPhotosFragment = new TeamPhotosFragment();
                return teamPhotosFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
