package com.hazfutbol.hfapp.fragments;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.adapter.TeamPagerAdapter;


public class TeamHomeFragment extends Fragment {

    private TabLayout tabTeamHome;
    private ViewPager pagTeamHome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_home, container, false);

        tabTeamHome = (TabLayout) view.findViewById(R.id.tabTeamHome);
        tabTeamHome.addTab(tabTeamHome.newTab().setText(getResources().getString(R.string.wall)), true);
        tabTeamHome.addTab(tabTeamHome.newTab().setText(getResources().getString(R.string.players)));
        tabTeamHome.addTab(tabTeamHome.newTab().setText(getResources().getString(R.string.photos)));
        tabTeamHome.setTabTextColors(ContextCompat.getColor(getContext(), R.color.white),
                ContextCompat.getColor(getContext(), R.color.white));
        tabTeamHome.setTabGravity(TabLayout.GRAVITY_FILL);
        tabTeamHome.setSelectedTabIndicatorColor(ContextCompat.getColor(getContext(), R.color.hf_pink));
        tabTeamHome.setSelectedTabIndicatorHeight(6);

        pagTeamHome = (ViewPager) view.findViewById(R.id.pagTeamHome);
        TeamPagerAdapter teamPagerAdapter =
                new TeamPagerAdapter(getFragmentManager(), tabTeamHome.getTabCount());

        pagTeamHome.setAdapter(teamPagerAdapter);
        pagTeamHome.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabTeamHome));
        tabTeamHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pagTeamHome.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

}
