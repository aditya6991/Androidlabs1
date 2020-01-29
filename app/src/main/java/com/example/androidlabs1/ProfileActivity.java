package com.example.androidlabs1;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;


import android.os.Bundle;



@SuppressLint("Registered")
public class ProfileActivity extends AppCompatActivity{
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String ACTIVITY_NAME = "ProfileActivity";
    private ImageButton mImageButton;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_relative);
        //setContentView(R.layout.activity_main_grid);
        //setContentView(R.layout.activity_main_linear);
        setContentView(R.layout.profileactivity);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        mImageButton = findViewById(R.id.imageButton);


        EditText enteremail = findViewById(R.id.EnterYourEmail);
        enteremail.setText(email);

        final ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dispatchTakePictureIntent();


            }
        });




    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(ACTIVITY_NAME, "in onResume()");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(ACTIVITY_NAME, "in onStart()");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(ACTIVITY_NAME, "in onPause()");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(ACTIVITY_NAME, "in onStop()");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "in onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //mageView mImageButton =null;
            mImageButton.setImageBitmap(imageBitmap);
        }
    }


    public void sendMessage(View view) {
    }
}
