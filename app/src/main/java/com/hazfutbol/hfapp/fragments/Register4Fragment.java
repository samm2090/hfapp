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
import com.hazfutbol.hfapp.models.Player;
import com.hazfutbol.hfapp.models.PlayerPosition;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.utils.Utilities;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User registration fourth view
 */
public class Register4Fragment extends Fragment {

    private static final int REQUEST_CODE_IMG_PICKER = 1;
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
    private String fileName;
    private String fileContent;

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

        rbGoalkeeper.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating < 1){
                    rbGoalkeeper.setRating(1);
                }
            }
        });

        rbDefender.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating < 1){
                    rbDefender.setRating(1);
                }
            }
        });

        rbMidFielder.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating < 1){
                    rbMidFielder.setRating(1);
                }
            }
        });

        rbForward.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating < 1){
                    rbForward.setRating(1);
                }
            }
        });

        btnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images
                        .Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, REQUEST_CODE_IMG_PICKER);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = txtNickname.getText().toString();
                String goalKeeperStatus = String.valueOf(Math.round(rbGoalkeeper.getRating()));
                String defenderStatus = String.valueOf(Math.round(rbDefender.getRating()));
                String midfielderStatus = String.valueOf(Math.round(rbMidFielder.getRating()));
                String forwardStatus = String.valueOf(Math.round(rbForward.getRating()));

                if (fileContent != null) {
                    Bundle bundle = getArguments();

                    bundle.putString(MyConstants.FILE_NAME, fileName);
                    bundle.putString(MyConstants.FILE_CONTENT, fileContent);
                    Player player = bundle.getParcelable(MyConstants.PLAYER);
                    player.setPlayerNick(nickname);

                    ArrayList<PlayerPosition> playerPositions = new ArrayList<PlayerPosition>();
                    for (int i = 1; i <= 10; i++) {
                        PlayerPosition playerPosition = new PlayerPosition();
                        playerPosition.setnPositionPreferId(i);
                        if (i == 1) {
                            playerPosition.setPositionPreferStatus(goalKeeperStatus);
                        } else if (i <= 4) {
                            playerPosition.setPositionPreferStatus(defenderStatus);
                        } else if (i <= 7) {
                            playerPosition.setPositionPreferStatus(midfielderStatus);
                        } else {
                            playerPosition.setPositionPreferStatus(forwardStatus);
                        }

                        playerPositions.add(playerPosition);
                    }

                    bundle.putParcelable(MyConstants.PLAYER, player);
                    bundle.putParcelableArrayList(MyConstants.PLAYER_POSITIONS, playerPositions);

                    Register5Fragment page5 = new Register5Fragment();
                    page5.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_register4, page5);
                    fragmentTransaction.addToBackStack(null);

                    Utilities.hideSoftKeyboard(getActivity());
                    fragmentTransaction.commit();
                } else {
                    Toast.makeText(myContext, myResources.getString(R.string
                            .user_register_incomplete4), Toast
                            .LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_IMG_PICKER) {
            if (resultCode == getActivity().RESULT_OK) {
                Uri selectedImage = data.getData();
                CropImage.activity(selectedImage).start(myContext, this);
            }
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == getActivity().RESULT_OK) {
                String originalPath = result.getOriginalUri().getPath();
                fileName = originalPath.substring(originalPath.lastIndexOf("/") + 1);
                File file = new File(result.getUri().getPath());
                profileImage.setImageURI(result.getUri());
                try {
                    fileContent = Utilities.encodeFileBase64(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
