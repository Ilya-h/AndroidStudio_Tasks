package com.apn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate MainActivity");

        Button openButton = findViewById(R.id.btn_open);
        openButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart MainActivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume MainActivity");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause MainActivity");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop MainActivity");
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy MainActivity");
    }

}