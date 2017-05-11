package com.hazfutbol.hfapp.webServices;

import com.hazfutbol.hfapp.models.Team;
import com.hazfutbol.hfapp.utils.MyConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TeamService {

    public List<Team> listTeamsByUser(int userId) throws IOException, JSONException {

        List<Team> teams = new ArrayList<>();
        String myURL = MyConstants.BASE_URL + "/user/group?format=json&id=" + userId;
        URL url = new URL(myURL);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("GET");

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        StringBuilder jsonString = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonString.append(line);
        }

        JSONObject jsonObject = new JSONObject(jsonString.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("groups");

        Team team;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonTeam = jsonArray.getJSONObject(i);
            team = new Team();
            team.setGroupId(jsonTeam.isNull("group_id") ? null : jsonTeam.optInt("group_id"));
            team.setUserId(jsonTeam.isNull("user_id") ? null : jsonTeam.optInt("user_id"));
            team.setGroupName(jsonTeam.isNull("group_name") ? null : jsonTeam.optString("group_name"));
            team.setGroupPhoto(jsonTeam.isNull("group_photo") ? null : jsonTeam.optString("storage_path"));
            team.setGroupMemberCount(jsonTeam.isNull("group_member_count") ? null : jsonTeam.optInt("group_member_count"));
            team.setGroupId(jsonTeam.isNull("group_shortname") ? null : jsonTeam.optInt("group_shortname"));
            teams.add(team);
        }
        return teams;
    }
}
