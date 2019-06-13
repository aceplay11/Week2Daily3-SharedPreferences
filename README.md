# Week2Daily3-SharedPreferences

Create an activity with an edittext for each item listed below.  On a button click,  save the values of the items listed below to shared preferences.  Then open another activity and display each item saved in the MainActivity to SEPARATE textviews.
Hint: this is week 1 day 3 homework, just refactored to use shared preferences :)
 
	First Name
	Last Name
	Street Address
	City
	State
	Zip
  
  
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
        setContentView(R.layout.activity_main);
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


<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/holo_purple"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/etFirstName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:textSize="20sp"
        android:hint="@string/first_name"
        android:background="@android:color/darker_gray"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/etLastName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:textSize="20sp"
        android:hint="@string/last_name"
        android:background="@android:color/darker_gray"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/etFirstName" />

    <EditText
        android:id="@+id/etAddress"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:textSize="20sp"
        android:background="@android:color/darker_gray"
        android:hint="@string/street_address"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/etLastName" />

    <EditText
        android:id="@+id/etCity"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:textSize="20sp"
        android:background="@android:color/darker_gray"
        android:hint="@string/city"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/etAddress" />

    <EditText
        android:id="@+id/etState"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:textSize="20sp"
        android:background="@android:color/darker_gray"
        android:hint="@string/state"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/etCity" />

    <EditText
        android:id="@+id/etZip"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:textSize="20sp"
        android:background="@android:color/darker_gray"
        android:hint="@string/zip"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/etState" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="50dp"
        android:padding="5dp"
        android:textSize="20sp"
        android:background="@android:color/darker_gray"
        android:textColor="@android:color/holo_blue_dark"
        android:onClick="onClick"
        android:text="@string/submit_shared_info"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/etZip"/>


</androidx.constraintlayout.widget.ConstraintLayout>


![Screen Shot 2019-06-13 at 2 20 30 PM](https://user-images.githubusercontent.com/51377336/59458378-51740d80-8de8-11e9-8156-386fe48bdb38.png)


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

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:background="@android:color/holo_orange_dark"
tools:context=".StorePreferences">

<TextView
    android:id="@+id/tvFirstName"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:textSize="20sp"
    android:background="@android:color/darker_gray"
    android:textColor="@android:color/holo_red_dark"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

<TextView
    android:id="@+id/tvLastName"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:textSize="20sp"
    android:background="@android:color/darker_gray"
    android:textColor="@android:color/holo_red_dark"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tvFirstName" />

<TextView
    android:id="@+id/tvAddress"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:textSize="20sp"
    android:background="@android:color/darker_gray"
    android:textColor="@android:color/holo_red_dark"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tvLastName" />

<TextView
    android:id="@+id/tvCity"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:textSize="20sp"
    android:background="@android:color/darker_gray"
    android:textColor="@android:color/holo_red_dark"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tvAddress" />

<TextView
    android:id="@+id/tvState"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:textSize="20sp"
    android:background="@android:color/darker_gray"
    android:textColor="@android:color/holo_red_dark"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tvCity" />

<TextView
    android:id="@+id/tvZip"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:textSize="20sp"
    android:background="@android:color/darker_gray"
    android:textColor="@android:color/holo_red_dark"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tvState" />





</androidx.constraintlayout.widget.ConstraintLayout>


![Screen Shot 2019-06-13 at 2 21 47 PM](https://user-images.githubusercontent.com/51377336/59458379-51740d80-8de8-11e9-93f3-1db180fa0eab.png)
