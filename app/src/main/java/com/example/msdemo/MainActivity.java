package com.example.msdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	getSupportFragmentManager().beginTransaction()
		.replace(R.id.activity_main, MainFragment.getFragment(getSupportFragmentManager())).addToBackStack(MainFragment.class.getSimpleName()).commit();
 }
}