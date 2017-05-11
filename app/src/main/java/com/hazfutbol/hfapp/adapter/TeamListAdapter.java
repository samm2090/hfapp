package com.hazfutbol.hfapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.Team;
import com.hazfutbol.hfapp.utils.Utility;
import com.hazfutbol.hfapp.viewHolders.TeamViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Team> myTeams;
    private Context myContext;

    public TeamListAdapter(Context context, List<Team> teams) {
        this.myTeams = teams;
        this.myContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_team, parent, false);
        TeamViewHolder teamViewHolder = new TeamViewHolder(view);
        return teamViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TeamViewHolder teamViewHolder = (TeamViewHolder) holder;

        Picasso.with(myContext).
                load(Utility.getImgFullUrl(myTeams.get(position).
                        getGroupPhoto())).error(R.color.hf_blue).into(teamViewHolder.imgEmblem);
        teamViewHolder.lblTeamName.setText(myTeams.get(position).getGroupName());
        teamViewHolder.lblNumberOfMembers.
                setText(myTeams.get(position).getGroupMemberCount().toString() + " Jugadores");

    }

    @Override
    public int getItemCount() {
        return (null != myTeams ? myTeams.size() : 0);
    }

}
