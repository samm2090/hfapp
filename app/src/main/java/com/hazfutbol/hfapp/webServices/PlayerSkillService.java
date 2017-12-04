package com.hazfutbol.hfapp.webServices;

import com.hazfutbol.hfapp.models.PlayerSkill;
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

public class PlayerSkillService {

    public List<PlayerSkill> listPlayerSkills() throws IOException, JSONException {

        List<PlayerSkill> playerSkills = new ArrayList<PlayerSkill>();
        String myURL = MyConstants.BASE_URL + "/user/player-skill?id=&format=json";
        URL url = new URL(myURL);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        StringBuilder jsonString = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonString.append(line);
        }

        JSONObject jsonObject = new JSONObject(jsonString.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("skills");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject skill = jsonArray.getJSONObject(i);
            PlayerSkill playerSkill = new PlayerSkill();
            playerSkill.setSkillId(skill.isNull("skill_id") ? null : skill.optInt("skill_id"));
            playerSkill.setSkillName(skill.isNull("skill_name") ? null : skill.optString("skill_name"));
            playerSkill.setSkillNameGroup(skill.isNull("skill_name_group") ? null : skill.optString("skill_name_group"));

            playerSkills.add(playerSkill);
        }

        if(httpConnection != null){
            httpConnection.disconnect();
        }

        return  playerSkills;
    }
}
