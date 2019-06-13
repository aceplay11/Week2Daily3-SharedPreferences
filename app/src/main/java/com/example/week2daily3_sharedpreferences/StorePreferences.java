package com.example.week2daily3_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.TextView;

public class StorePreferences extends AppCompatActivity {

    TextView tvFirstName;
    TextView tvLastName;
    TextView tvAddress;
    TextView tvCity;
    TextView tvState;
    TextView tvZip;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_preferences);
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvAddress = findViewById(R.id.tvAddress);
        tvCity = findViewById(R.id.tvCity);
        tvState = findViewById(R.id.tvState);
        tvZip = findViewById(R.id.tvZip);
        sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        tvFirstName.setText(retreiveFromSharedPref("first"));
        tvLastName.setText(retreiveFromSharedPref("last"));
        tvAddress.setText(retreiveFromSharedPref("address"));
        tvCity.setText(retreiveFromSharedPref("city"));
        tvState.setText(retreiveFromSharedPref("state"));
        tvZip.setText(retreiveFromSharedPref("zip"));
    }

    private String retreiveFromSharedPref(String key) {
        return sharedPreferences.getString(key, "NOTHING SAVED");
    }
}
