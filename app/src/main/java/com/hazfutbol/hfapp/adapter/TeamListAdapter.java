package com.hazfutbol.hfapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.Team;

import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Team> myTeams;
    private Context myContext;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_team, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class TeamViewHolder extends RecyclerView.ViewHolder {



        public TeamViewHolder(View view) {
            super(view);


        }

    }
}
