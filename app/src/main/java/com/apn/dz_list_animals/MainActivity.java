package com.apn.dz_list_animals;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AnimalAdapter animalAdapter;
    List<Animal> animals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        animals = new ArrayList<>();


        //Заполнение списка животных
        String[] animalNames = { "Кот", "Собака", "Тигр", "Слон"};
        for(String name: animalNames){
            animals.add(new Animal(name));
        }

        //Настройка RecyclerView
        animalAdapter = new AnimalAdapter(animals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);
    }
}