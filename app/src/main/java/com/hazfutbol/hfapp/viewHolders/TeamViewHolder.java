package com.hazfutbol.hfapp.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hazfutbol.hfapp.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class TeamViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgEmblem;
    public TextView lblNumberOfMembers;
    public TextView lblTeamName;
    public RatingBar teamRatingBar;

    public TeamViewHolder(View itemView) {
        super(itemView);
        imgEmblem = (CircleImageView) itemView.findViewById(R.id.imgEmblem);
        lblNumberOfMembers = (TextView) itemView.findViewById(R.id.lblNumberOfMembers);
        lblTeamName = (TextView) itemView.findViewById(R.id.lblTeamName);
        teamRatingBar = (RatingBar) itemView.findViewById(R.id.teamRatingBar);
    }
}
