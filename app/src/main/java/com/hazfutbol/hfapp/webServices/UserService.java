package com.hazfutbol.hfapp.webServices;

import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.utils.Utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class UserService {

    public boolean insertUser(User user) throws IOException {
        boolean isInserted = false;

        Map<String, String> dataToSend = new HashMap<String, String>();
        dataToSend.put("names", user.getUserName());
        dataToSend.put("lastnames", user.getUserLastName());
        dataToSend.put("email", user.getUserEmail());
        dataToSend.put("password", user.getUserPassword());
        dataToSend.put("format", "json");
        String encodedString = Utilities.encodeMap(dataToSend);

        String myUrl = MyConstants.BASE_URL + "/user/register";

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
            isInserted = true;
        }

        return isInserted;
    }

    public User login(String username, String password) throws IOException {
        User user = null;

        Map<String, String> dataToSend = new HashMap<String, String>();
        dataToSend.put("username", username);
        dataToSend.put("userpassword", password);
        dataToSend.put("format", "json");
        String encodedString = Utilities.encodeMap(dataToSend);

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
            try {
                JSONObject jsonUser = Utilities.getJsonFromWS(connection);
                user = new User();
                user.setUserId(jsonUser.getInt("user_id"));
                user.setUserEmail(jsonUser.getString("user_email"));
                user.setUserName(jsonUser.getString("user_name"));
                user.setUserLastName(jsonUser.getString("user_lastname"));
                user.setUserStatus(jsonUser.getInt("user_status"));
                user.setUserCommunity(jsonUser.getInt("user_community"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

}
