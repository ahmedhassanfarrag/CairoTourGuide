package com.example.android.cairotourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Category extends AppCompatActivity {
    // Create a global variables to use in put.extra method.
    private String location_name;
    private String phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);
        // Find the TextView in the MusicPlayer.xml layout with the ID song.
        TextView name = (TextView) findViewById(R.id.museum_name);

        // Find the ImageView in the MusicPlayer.xml layout with the ID image.
        ImageView Image = (ImageView) findViewById(R.id.museum_image);

        // Find the TextView in the MusicPlayer.xml layout with the ID author.
        TextView info = (TextView) findViewById(R.id.museum_info);


        // Receiving the intent extras that were put in the fragments
        final Bundle extras = getIntent().getExtras();

        // Getting the Views from xml
        name.setText(extras.getString(getString(R.string.put_extra_1)));
        info.setText(extras.getString(getString(R.string.put_extra_2)));
        Image.setImageResource(extras.getInt(getString(R.string.put_extra_3)));
        location_name = extras.getString(getString(R.string.put_extra_4));
        phoneNumber = extras.getString(getString(R.string.put_extra_5));
        // define map button.
        ImageButton map = (ImageButton) findViewById(R.id.map);
        // set a click listener to open google map.
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(location_name);
            }
        });
        // define call button.
        final ImageButton call = (ImageButton) findViewById(R.id.call);
        // set a click listener to open a Dialer.
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPhoneNumber(phoneNumber);
            }
        });

    }

    // Create showMap method to define location name of each item in places array list .
    public void showMap(String location_name) {
        String location = getString(R.string.location) + location_name;
        Uri gmmIntentUri = Uri.parse(location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage(getString(R.string.package_map));
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

    // Create showPhoneNumber method to define phone number of each item in places array list .
    public void showPhoneNumber(String phoneNumber) {
        String number = getString(R.string.number) + phoneNumber;
        Uri gmmIntentUri = Uri.parse(number);
        Intent mapIntent = new Intent(Intent.ACTION_DIAL, gmmIntentUri);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }
}
