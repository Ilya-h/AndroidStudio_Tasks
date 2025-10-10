package com.apn.dz_webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnOpenWeb;
    Button btnGoBack;
    long backPressedTime;

    // URL для открытия
    private static final String WEB_URL = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация кнопок
        btnOpenWeb = findViewById(R.id.btnOpenWeb);
        btnGoBack = findViewById(R.id.btnGoBack);

        // Обработчик для кнопки открытия веб-страницы
        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(WEB_URL);
            }
        });

        // Обработчик для кнопки "Назад"
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    // Метод для открытия веб-страницы
    private void openWebPage(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Не удалось открыть страницу", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    // Обработка системной кнопки "Назад"
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Нажмите еще раз для выхода", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}