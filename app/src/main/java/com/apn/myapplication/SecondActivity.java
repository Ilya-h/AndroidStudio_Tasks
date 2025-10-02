package com.apn.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate SecondActivity");

        TextView textView = findViewById(R.id.tv_message);
        textView.setText("Я запустился!");

        Button browserButton = findViewById(R.id.btn_browser);
        browserButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com"));
            startActivity(intent);
        });

        Button backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart SecondActivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume SecondActivity");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause SecondActivity");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop SecondActivity");
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy SecondActivity");
    }

}
