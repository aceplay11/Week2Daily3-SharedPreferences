package com.example.week2daily3_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etFirstName;
    EditText etLastName;
    EditText etAddress;
    EditText etCity;
    EditText etState;
    EditText etZip;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_preferences);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
        sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);

    }

    public void onClick(View view) {
        storeToSharedPerf("first", etFirstName.getText().toString());
        storeToSharedPerf("last", etLastName.getText().toString());
        storeToSharedPerf("address", etAddress.getText().toString());
        storeToSharedPerf("city", etCity.getText().toString());
        storeToSharedPerf("state", etState.getText().toString());
        storeToSharedPerf("zip", etZip.getText().toString());
        startActivity(new Intent(this, StorePreferences.class));


    }

    private void storeToSharedPerf(String key, String string) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, string);
        editor.apply();
    }

}


