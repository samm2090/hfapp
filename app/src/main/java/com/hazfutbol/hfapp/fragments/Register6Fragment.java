package com.hazfutbol.hfapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.hazfutbol.hfapp.models.Player;
import com.hazfutbol.hfapp.models.PlayerPosition;
import com.hazfutbol.hfapp.models.PlayerSkill;
import com.hazfutbol.hfapp.models.User;
import com.hazfutbol.hfapp.utils.MyConstants;
import com.hazfutbol.hfapp.webServices.UserService;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User registration last view
 */
public class Register6Fragment extends Fragment {

    private Context myContext;
    private Resources myResources;
    private Button btnCreateAccount;
    //    private TextView termsText;
    private WebView webViewTerms;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register6, container, false);

        myContext = getActivity().getApplicationContext();
        myResources = myContext.getResources();
//        termsText = (TextView) view.findViewById(R.id.termsText);
        webViewTerms = (WebView) view.findViewById(R.id.webViewTerms);
        webViewTerms.loadDataWithBaseURL(MyConstants.TEXT_EMPTY, myResources.getString(R.string
                .terms_full_text), MyConstants.HTML_MIME_TYPE, MyConstants.HTML_ENCODING, null);
//        webViewTerms.loadData(myResources.getString(R.string.terms_full_text),"text/html","UTF-8");
//        termsText.setText(Html.fromHtml(myResources.getString(R.string.terms_full_text)));
        btnCreateAccount = (Button) view.findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Register6Fragment.UserRegisterAsyncTask().execute();

            }
        });

        return view;
    }

    private class UserRegisterAsyncTask extends AsyncTask<Void, String, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            boolean result = false;
            Bundle bundle = getArguments();

            User user = bundle.getParcelable(MyConstants.USER);
            Player player = bundle.getParcelable(MyConstants.PLAYER);
            String fileName = bundle.getString(MyConstants.FILE_NAME);
            String fileContent = bundle.getString(MyConstants.FILE_CONTENT);
            ArrayList<PlayerPosition> playerPositions = bundle.getParcelableArrayList(MyConstants
                    .PLAYER_POSITIONS);
            ArrayList<PlayerSkill> playerSkills = bundle.getParcelableArrayList(MyConstants
                    .PLAYER_SKILLS);

            UserService userService = new UserService();

            try {
                result = userService.createUser(user, player, fileName, fileContent, playerPositions,
                        playerSkills);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {


            } else {
                Toast.makeText(myContext, "error", Toast.LENGTH_SHORT);
            }
        }
    }

}
