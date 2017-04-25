package com.hazfutbol.hfapp.webServices;

import com.hazfutbol.hfapp.models.City;
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

public class CityService {

    public List<City> listCities() throws IOException, JSONException {

        List<City> cities = new ArrayList<>();
        String myURL = MyConstants.BASE_URL + "/user/city?id=15&id2=7&format=json";
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
        JSONArray jsonArray = jsonObject.getJSONArray("cities");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonCity = jsonArray.getJSONObject(i);
            City city = new City();
            city.setCityId(jsonCity.isNull("city_id") ? null : jsonCity.optInt("city_id"));
            city.setProvinceId(jsonCity.isNull("province_id") ? null : jsonCity.optInt("province_id"));
            city.setCityName(jsonCity.isNull("city_name") ? null : jsonCity.optString("city_name"));
            city.setStatus(jsonCity.isNull("status") ? null : jsonCity.optInt("status"));
            cities.add(city);
        }
        return cities;
    }
}
