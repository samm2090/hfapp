package com.hazfutbol.hfapp.utils;

import android.content.Context;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class Utility {

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

    public static int getResourceIdByName(Context context, String type, String name) {
        int resourceId = context.getResources().getIdentifier(name, type,
                context.getPackageName());

        return resourceId;
    }
}
