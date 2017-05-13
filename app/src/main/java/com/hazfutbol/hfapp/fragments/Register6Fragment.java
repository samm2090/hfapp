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

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * User registration fourth view
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
                Toast.makeText(myContext,"entor",Toast.LENGTH_SHORT).show();
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
            String filePath = bundle.getString(MyConstants.FILE_PATH);
            ArrayList<PlayerPosition> playerPositions = bundle.getParcelableArrayList(MyConstants
                    .PLAYER_POSITIONS);
            ArrayList<PlayerSkill> playerSkills = bundle.getParcelableArrayList(MyConstants
                    .PLAYER_SKILLS);



//            FTPClient ftpClient = new FTPClient();
//            try {
//
//                ftpClient.connect(MyConstants.SERVER_IP, Integer.valueOf(MyConstants.SERVER_PORT));
//                ftpClient.login(MyConstants.SERVER_USER, MyConstants.SERVER_PASS);
//                ftpClient.enterLocalPassiveMode();
//
//                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//
//                File file = new File(filePath);
//                String remoteFilePath = "/home/ftp_springloops/" + fileName + ".png";
//
//                InputStream inputStream = new FileInputStream(file);
//                System.out.println(ftpClient.storeFile(remoteFilePath, inputStream));
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (ftpClient.isConnected()) {
//                    try {
//                        ftpClient.logout();
//                        ftpClient.disconnect();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }


//            UserService userService = new UserService();
//            try {
//                userService.insertUser(params[0]);
//                result = true;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

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
