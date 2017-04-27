package com.hazfutbol.hfapp.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.City;
import com.hazfutbol.hfapp.webServices.CityService;

import java.util.ArrayList;
import java.util.List;


public class CreateTeamFragment extends Fragment {

    private Spinner spCities;
    private EditText txtTeamName;
    private Button btnNext;
    private List<City> cities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_team, container, false);

        spCities = (Spinner) view.findViewById(R.id.spCities);
        txtTeamName = (EditText) view.findViewById(R.id.txtTeamName);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        cities = new ArrayList<City>();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTeamFragment2 createTeamFragment2 = new CreateTeamFragment2();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), createTeamFragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        new CreateTeamFragment.CitiesAsyncTask().execute();

        return view;
    }

    private class CitiesAsyncTask extends AsyncTask<Void, String, Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {
            Boolean result = false;

            try {
                CityService cityService = new CityService();
                cities = cityService.listCities();
                result = true;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (result) {
                ArrayAdapter<City> adapter = new ArrayAdapter<City>(getContext(), R.layout.spinner_item_blue, cities);
                spCities.setAdapter(adapter);
            } else {
                Toast.makeText(getContext(), "Error al cargar datos", Toast.LENGTH_SHORT);
            }
        }
    }
}
