package com.hazfutbol.hfapp.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.cunoraz.tagview.Tag;
import com.cunoraz.tagview.TagView;
import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.PlayerSkill;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.webServices.PlayerSkillService;
import com.hazfutbol.hfapp.webServices.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ninosimeon on 09/02/17.
 */

public class Register5Fragment extends Fragment {

    Spinner spPlayerSkills;
    TagView tagGroup;
    int colorCounter;
    List<PlayerSkill> playerSkills;
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register5, container, false);
        colorCounter = 1;
        btnNext = (Button) view.findViewById(R.id.btnNext);
        spPlayerSkills = (Spinner) view.findViewById(R.id.spPlayerSkills);
        tagGroup = (TagView) view.findViewById(R.id.tagGroupPlayerSkills);
        playerSkills = new ArrayList<PlayerSkill>();

        new Register5Fragment.PlayerSkillsAsynkTask().execute();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        spPlayerSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PlayerSkill playerSkill = (PlayerSkill) spPlayerSkills.getSelectedItem();
                Tag tag = new Tag(playerSkill.getSkillName());
                tag.isDeletable = true;

                switch (colorCounter) {
                    case 1:
                        tag.layoutColor = Color.parseColor("#00719d");
                        colorCounter += 1;
                        break;
                    case 2:
                        tag.layoutColor = Color.parseColor("#ff408e");
                        colorCounter += 1;
                        break;
                    case 3:
                        tag.layoutColor = Color.parseColor("#ff9700");
                        colorCounter += 1;
                        break;
                    case 4:
                        tag.layoutColor = Color.parseColor("#009a54");
                        colorCounter += 1;
                        break;
                    case 5:
                        tag.layoutColor = Color.parseColor("#c640af");
                        colorCounter += 1;
                        break;
                    case 6:
                        tag.layoutColor = Color.parseColor("#ff4d5d");
                        colorCounter += 1;
                        break;
                    case 7:
                        tag.layoutColor = Color.parseColor("#9552bc");
                        colorCounter += 1;
                        break;
                    default:
                        tag.layoutColor = Color.parseColor("#00acd2");
                        colorCounter = 1;
                        break;
                }
                playerSkills.add(playerSkill);
                tagGroup.addTag(tag);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tagGroup.setOnTagDeleteListener(new TagView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(TagView tagView, Tag tag, int i) {
                tagView.remove(i);
                playerSkills.remove(tag.id);
            }
        });

        return view;
    }

    private class PlayerSkillsAsynkTask extends AsyncTask<Void, String, Boolean> {

        private List<PlayerSkill> playerSkills = new ArrayList<PlayerSkill>();

        @Override
        protected Boolean doInBackground(Void... params) {

            Boolean result = false;

            try {
                PlayerSkillService playerSkillService = new PlayerSkillService();
                playerSkills = playerSkillService.playerSkills();
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
                ArrayAdapter<PlayerSkill> adapter = new ArrayAdapter<PlayerSkill>(getContext(), android.R.layout.simple_spinner_dropdown_item, playerSkills);

                spPlayerSkills.setAdapter(adapter);
            } else {
                Toast.makeText(getContext(), "Error al cargar datos", Toast.LENGTH_SHORT);
            }
        }
    }

    private class UserRegisterAsyncTask extends AsyncTask<User, String, Boolean> {

        @Override
        protected Boolean doInBackground(User... params) {

            boolean result = false;

            UserService userService = new UserService();
            try {
                userService.insertUser(params[0]);
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {


            } else {
            }
        }
    }


}
