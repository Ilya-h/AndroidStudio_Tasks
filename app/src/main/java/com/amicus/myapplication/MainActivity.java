package com.amicus.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    PaintView paintView;
    Button saveButton;
    Button change;
    Button clear;
    Button eracer;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = findViewById(R.id.paintView);
        saveButton = findViewById(R.id.btnSave);
        change = findViewById(R.id.btnColor);
        clear = findViewById(R.id.clear);
        eracer = findViewById(R.id.btnEraser);
        cancel = findViewById(R.id.btnCancel);

        saveButton.setOnClickListener(v->{
            paintView.saveToGallery(this);
        });

        clear.setOnClickListener(v->{
            paintView.clearCanvas();
        });

        change.setOnClickListener(v->{
            paintView.changeColor(change);
        });

        eracer.setOnClickListener(v->{
            paintView.eraser();
        });

        //Добавлена кнопка отмены
        cancel.setOnClickListener(v->{
            finish();
        });
    }
}