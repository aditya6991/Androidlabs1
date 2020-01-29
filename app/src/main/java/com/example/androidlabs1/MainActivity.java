package com.example.androidlabs1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;

    public static final String mypreference = "sharedPrefs";
    public static final String Email = "emailKey";
    protected Button button;


    EditText email;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_relative);
        //setContentView(R.layout.activity_main_grid);
        //setContentView(R.layout.activity_main_linear);
        setContentView(R.layout.layout_lab3);

        button = findViewById(R.id.button2);
        email = findViewById(R.id.edittext);
        prefs = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (prefs.contains(Email)) {
            email.setText(prefs.getString(Email, ""));
        }


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Switch to ListItemsActivity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                EditText edits= findViewById(R.id.edittext);
                String novo = edits.getText().toString();
                intent.putExtra("email", novo);
                startActivity(intent);
            }

        });


    }
    @Override
    protected void onPause() {
        String e = email.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences( mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Email, e);
        editor.apply();





        super.onPause();

    }

}