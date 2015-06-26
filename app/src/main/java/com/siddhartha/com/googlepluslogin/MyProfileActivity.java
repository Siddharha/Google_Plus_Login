package com.siddhartha.com.googlepluslogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfileActivity extends AppCompatActivity {

    private ImageView imgProfilePic;
    private TextView txtName, txtEmail;

    String personName,email,personPhotoUrl,aboutMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        //flSrt.setVisibility(View.VISIBLE);
       initialize();
        getResult();
        loadData();
        debug();
    }

    private void initialize() {
        imgProfilePic = (ImageView) findViewById(R.id.imgProfilePic);
        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);



    }

    private void debug() {
        Log.e("Message --> ","Name: "+personName+"Email: "+email+"Image URI: "+personPhotoUrl+"About Me: "+aboutMe);
    }

    private void loadData() {
        txtName.setText(personName);
        txtEmail.setText(email);

        new LoadProfileImage(imgProfilePic).execute(personPhotoUrl);
    }


    public void getResult() {

        personName = getIntent().getStringExtra("Name");
        email = getIntent().getStringExtra("Email");
        personPhotoUrl = getIntent().getStringExtra("Image");
        aboutMe = getIntent().getStringExtra("About Me");

    }
}
