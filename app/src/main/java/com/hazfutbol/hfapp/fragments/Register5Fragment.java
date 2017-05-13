package com.hazfutbol.hfapp.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cunoraz.tagview.Tag;
import com.cunoraz.tagview.TagView;
import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.PlayerSkill;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.utils.Utilities;
import com.hazfutbol.hfapp.webServices.PlayerSkillService;
import com.hazfutbol.hfapp.webServices.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User registration fifth view
 */
public class Register5Fragment extends Fragment {

    private Context myContext;
    private Resources myResources;
    private Spinner spPlayerSkills;
    private TagView tagGroup;
    private EditText txtExtraSkill;
    private TextView lblSkip;
    private int colorCounter;
    private ArrayList<PlayerSkill> playerSkills;
    private Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register5, container, false);

        myContext = getActivity().getApplicationContext();
        myResources = myContext.getResources();
        btnNext = (Button) view.findViewById(R.id.btnNext);
        spPlayerSkills = (Spinner) view.findViewById(R.id.spPlayerSkills);
        tagGroup = (TagView) view.findViewById(R.id.tagGroupPlayerSkills);
        txtExtraSkill = (EditText) view.findViewById(R.id.txtExtraSkill);
        lblSkip = (TextView) view.findViewById(R.id.lblSkip);
        playerSkills = new ArrayList<PlayerSkill>();
        colorCounter = 0;

        new Register5Fragment.PlayerSkillsAsynkTask().execute();

        lblSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                nextFragment(bundle);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                bundle.putParcelableArrayList(MyConstants.PLAYER_SKILLS, playerSkills);
                nextFragment(bundle);
            }
        });

        spPlayerSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (colorCounter == 0) {
                    colorCounter = 1;
                } else {
                    PlayerSkill playerSkill = (PlayerSkill) spPlayerSkills.getSelectedItem();
                    Tag tag = new Tag(playerSkill.getSkillName());
                    tag.isDeletable = true;

                    tag.layoutColor = getTagColor(colorCounter);
                    playerSkills.add(playerSkill);
                    tagGroup.addTag(tag);
                    colorCounter += 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txtExtraSkill.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    PlayerSkill playerSkill = new PlayerSkill();
                    playerSkill.setSkillName(txtExtraSkill.getText().toString());
                    playerSkills.add(playerSkill);

                    Tag tag = new Tag(playerSkill.getSkillName());
                    tag.layoutColor = getTagColor(colorCounter);
                    tag.isDeletable = true;
                    playerSkills.add(playerSkill);
                    tagGroup.addTag(tag);
                    colorCounter += 1;
                    txtExtraSkill.setText("");
                    Utilities.hideSoftKeyboard(getActivity());

                    return true;
                }
                return false;
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

    private void nextFragment(Bundle bundle) {
        Register6Fragment page5 = new Register6Fragment();
        page5.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_register5, page5);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    private int getTagColor(int colorCounter) {
        int color;
        switch (colorCounter) {
            case 1:
                color = ContextCompat.getColor(myContext, R.color.tag_blue);
                break;
            case 2:
                color = ContextCompat.getColor(myContext, R.color.tag_pink);
                break;
            case 3:
                color = ContextCompat.getColor(myContext, R.color.tag_orange);
                break;
            case 4:
                color = ContextCompat.getColor(myContext, R.color.tag_green);
                break;
            case 5:
                color = ContextCompat.getColor(myContext, R.color.tag_purple);
                break;
            case 6:
                color = ContextCompat.getColor(myContext, R.color.tag_red);
                break;
            case 7:
                color = ContextCompat.getColor(myContext, R.color.tag_light_blue);
                break;
            default:
                color = ContextCompat.getColor(myContext, R.color.tag_violet);
                break;
        }
        return color;
    }

    private class PlayerSkillsAsynkTask extends AsyncTask<Void, String, Boolean> {

        private List<PlayerSkill> playerSkills = new ArrayList<PlayerSkill>();

        @Override
        protected Boolean doInBackground(Void... params) {

            Boolean result = false;

            try {
                PlayerSkillService playerSkillService = new PlayerSkillService();
                playerSkills = playerSkillService.listPlayerSkills();
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
                ArrayAdapter<PlayerSkill> adapter = new ArrayAdapter<PlayerSkill>(getContext(),
                        R.layout.spinner_item_green, playerSkills);

                spPlayerSkills.setAdapter(adapter);
            } else {
                Toast.makeText(getContext(), "Error al cargar datos", Toast.LENGTH_SHORT);
            }
        }
    }

}
