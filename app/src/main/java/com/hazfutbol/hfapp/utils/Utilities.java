package com.hazfutbol.hfapp.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;

public final class Utilities {

    public static String encodeMap(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (String key : data.keySet()) {
            String value = null;
            try {
                value = URLEncoder.encode(data.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (sb.length() > 0)
                sb.append("&");

            sb.append(key + "=" + value);
        }
        return sb.toString();
    }

    public static String getImgFullUrl(String storagePath) {

        StringBuilder fullUrl = new StringBuilder(MyConstants.BASE_CDN_URL);
        fullUrl.append("/player/images/");
        fullUrl.append(storagePath);

        return fullUrl.toString();
    }

    public static int getResourceIdByName(Context context, String type, String name) {
        int resourceId = context.getResources().getIdentifier(name, type,
                context.getPackageName());

        return resourceId;
    }

    public static JSONObject getJsonFromWS(HttpURLConnection connection) throws IOException,
            JSONException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder jsonString = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            jsonString.append(line + "\n");
        }
        return new JSONObject(jsonString.toString());
    }

    public static void hideSoftKeyboard(Activity activity) {
        activity.getCurrentFocus().clearFocus();
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService
                    (activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
}
