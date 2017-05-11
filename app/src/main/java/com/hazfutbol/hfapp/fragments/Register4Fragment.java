package com.hazfutbol.hfapp.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;

public class Register4Fragment extends Fragment {

    private Context myContext;
    private Resources myResources;
    private EditText txtNickname;
    private RatingBar rbGoalkeeper;
    private RatingBar rbDefender;
    private RatingBar rbMidFielder;
    private RatingBar rbForward;
    private Button btnUploadPhoto;
    private Button btnNext;
    private ImageView profileImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register4, container, false);

        myContext = getActivity().getApplicationContext();
        myResources = myContext.getResources();
        txtNickname = (EditText) view.findViewById(R.id.txtNickname);
        rbGoalkeeper = (RatingBar) view.findViewById(R.id.rbGoalkeeper);
        rbDefender = (RatingBar) view.findViewById(R.id.rbDefender);
        rbMidFielder = (RatingBar) view.findViewById(R.id.rbMidfielder);
        rbForward = (RatingBar) view.findViewById(R.id.rbForward);
        btnUploadPhoto = (Button) view.findViewById(R.id.btnUploadPhoto);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        profileImage = (ImageView) view.findViewById(R.id.profile_image);

        btnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, 1);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();

                Register5Fragment page5 = new Register5Fragment();
                page5.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_register4, page5);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {
            Uri selectedImage = data.getData();

            profileImage.setImageURI(selectedImage);

        }
    }
}
