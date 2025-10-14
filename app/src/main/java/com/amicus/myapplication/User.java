package com.amicus.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by sizik on 23.09.2025.
 */
@Entity(tableName = "mytable")
public class User {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String lastname;
    String email;
    String phone;
}
