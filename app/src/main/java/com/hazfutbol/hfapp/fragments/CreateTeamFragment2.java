package com.hazfutbol.hfapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.utils.Utility;


public class CreateTeamFragment2 extends Fragment {

    private Context myContext;
    private ImageView imgShapeSelected;
    private ImageView imgEmblem;
    private Button btnNext;
    private Button btnNextShape;
    private Button btnPreviousShape;
    private Button btnPreviousShapeColor;
    private Button btnNextShapeColor;
    int imgCurrentShape;
    int imgCurrentShapeColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_team2, container, false);

        myContext = getActivity().getApplicationContext();
        imgShapeSelected = (ImageView) view.findViewById(R.id.imgShape3);
        imgEmblem = (ImageView) view.findViewById(R.id.imgEmblem);
        btnNextShape = (Button) view.findViewById(R.id.btnNextShape);
        btnPreviousShape = (Button) view.findViewById(R.id.btnPreviousShape);
        btnNextShapeColor = (Button) view.findViewById(R.id.btnNextShapeColor);
        btnPreviousShapeColor = (Button) view.findViewById(R.id.btnPreviousShapeColor);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        imgCurrentShape = 3;
        imgCurrentShapeColor = 3;

        imgShapeSelected.setBackgroundResource(R.drawable.background_white_border_green);
        imgEmblem.setImageResource(R.drawable.emblem_shape_3);


        btnPreviousShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageViewId = Utility.getResourceIdByName(myContext, "id", "imgShape" + imgCurrentShape);
                imgShapeSelected = (ImageView) view.findViewById(imageViewId);
                imgShapeSelected.setBackgroundResource(R.drawable.background_white_border_black);

                imgCurrentShape--;

                int imgShapeId = Utility.
                        getResourceIdByName(myContext, "drawable", "emblem_shape_" + imgCurrentShape);
                imgEmblem.setImageResource(imgShapeId);
                imageViewId = Utility.getResourceIdByName(myContext, "id", "imgShape" + imgCurrentShape);
                imgShapeSelected = (ImageView) view.findViewById(imageViewId);
                imgShapeSelected.setBackgroundResource(R.drawable.background_white_border_green);
            }
        });

        btnNextShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageViewId = Utility.getResourceIdByName(myContext, "id", "imgShape" + imgCurrentShape);
                imgShapeSelected = (ImageView) view.findViewById(imageViewId);
                imgShapeSelected.setBackgroundResource(R.drawable.background_white_border_black);
                imgCurrentShape++;

                int imgShapeId = Utility.
                        getResourceIdByName(myContext, "drawable", "emblem_shape_" + imgCurrentShape);
                imgEmblem.setImageResource(imgShapeId);
                imageViewId = Utility.getResourceIdByName(myContext, "id", "imgShape" + imgCurrentShape);
                imgShapeSelected = (ImageView) view.findViewById(imageViewId);
                imgShapeSelected.setBackgroundResource(R.drawable.background_white_border_green);
            }
        });

        btnPreviousShapeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnNextShapeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTeamFragment3 createTeamFragment3 = new CreateTeamFragment3();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), createTeamFragment3);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
