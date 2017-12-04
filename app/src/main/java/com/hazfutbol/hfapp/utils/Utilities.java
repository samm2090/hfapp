package com.hazfutbol.hfapp.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public final class Utilities {

    public static String standardDateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return simpleDateFormat.format(date);
    }

    public static Date standardDateFormat(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return simpleDateFormat.parse(date);
    }

    public static String encodeMapString(Map<String, String> data) {
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

    public static String encodeFileBase64(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] fileBytes = IOUtils.toByteArray(fileInputStream);

        String encodedBytes = Base64.encodeToString(fileBytes, Base64.DEFAULT);

        fileInputStream.close();

        return encodedBytes;
    }

    public static String encodeMapObject(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (String key : data.keySet()) {
            String value = null;
            try {
                value = URLEncoder.encode(data.get(key).toString(), "UTF-8");
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
