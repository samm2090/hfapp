package com.hazfutbol.hfapp.webServices;

import android.util.Log;

import com.google.gson.Gson;
import com.hazfutbol.hfapp.models.Player;
import com.hazfutbol.hfapp.models.PlayerPosition;
import com.hazfutbol.hfapp.models.PlayerSkill;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UserService {

    public boolean createUser(User user, Player player, String fileName, String fileContent,
                              ArrayList<PlayerPosition>
            playerPositions, ArrayList<PlayerSkill> playerSkills) throws IOException, JSONException {
        boolean isInserted = false;

//        JSONArray jsonArray = new JSONArray();
/*        if (!playerPositions.isEmpty()) {
            for (PlayerPosition playerPosition : playerPositions) {
                JSONObject playerPositionId = new JSONObject();
                playerPositionId.put("playerPositionId", playerPositionId);
                jsonArray.put(playerPositionId);
            }
        }*/

        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);
        String playerJsonString = gson.toJson(player);
        String playerPositionsJsonString = gson.toJson(playerPositions);
        String playerSkillsJsonString = gson.toJson(playerPositions);

        JSONObject userJson = new JSONObject(userJsonString);
        JSONObject playerJson = new JSONObject(playerJsonString);
        JSONArray playerPositionsJson = new JSONArray(playerPositionsJsonString);
        JSONArray playerSkillsJson = new JSONArray(playerSkillsJsonString);

        JSONObject jsonData = new JSONObject();
        jsonData.put("user", userJson);
        jsonData.put("player", playerJson);
        jsonData.put("fileName", fileName);
        jsonData.put("fileContent", fileContent);
        jsonData.put("playerPositions", playerPositionsJson);
        jsonData.put("playerSkills", playerSkillsJson);

        Map<String, String> dataToSend = new HashMap<>();
        dataToSend.put("format", "json");
        dataToSend.put("data", jsonData.toString());

        Log.d("json", jsonData.toString());

        String myUrl = MyConstants.BASE_URL + "/user/register";

        URL url = new URL(myUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(Utilities.encodeMapString(dataToSend));
        writer.flush();
        writer.close();

        if (connection.getResponseCode() == 200) {
            isInserted = true;
        }

        Log.d("Error ", connection.getResponseCode() + " " + connection.getResponseMessage());

        if (connection != null) {
            connection.disconnect();
        }

        return isInserted;
    }

    public User login(String username, String password) throws IOException, JSONException {
        User user = null;

        Map<String, String> dataToSend = new HashMap<String, String>();
        dataToSend.put("username", username);
        dataToSend.put("userpassword", password);
        dataToSend.put("format", "json");
        String encodedString = Utilities.encodeMapString(dataToSend);

        String myUrl = MyConstants.BASE_URL + "/user/login";

        URL url = new URL(myUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(encodedString);
        writer.flush();
        writer.close();

        if (connection.getResponseCode() == 200) {

            JSONObject jsonUser = Utilities.getJsonFromWS(connection);
            user = new User();
            user.setUserId(jsonUser.getInt("user_id"));
            user.setUserEmail(jsonUser.getString("user_email"));
            user.setUserName(jsonUser.getString("user_name"));
            user.setUserLastName(jsonUser.getString("user_lastname"));
            user.setUserStatus(jsonUser.getInt("user_status"));
            user.setUserCommunity(jsonUser.getInt("user_community"));
        }

        if (connection != null) {
            connection.disconnect();
        }

        return user;
    }

}
