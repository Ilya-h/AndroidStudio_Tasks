package com.amicus.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button dateTimeButton;
    TextView current;

    // установка начального значение времени
    Calendar dateAndTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        dateTimeButton = findViewById(R.id.dateTimeButton);
        current = findViewById(R.id.textview1);
        setInitialDate();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //класс билдера для создания диалога
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //заголовок диалога
                builder.setTitle("Подтверждение");
                //иконка
                builder.setIcon(R.drawable.ic_launcher_background);
                //метод запрета на сворачивание диалога(опционально)
                builder.setCancelable(false);
                //сообщение пользователю
                builder.setMessage("Вы уверены что хотите выйти?");
                //кнопка согласия пользователя
                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                //кнопка отрицания пользователя
                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                    }
                });
                //кнопка нейтрального выбора
                /*
                builder.setNeutralButton("Не знаю", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                           //действие которое не вписывается ни в одну из предыдущих кнопок
                    }
                });
                 */
                //создание самого диалога и вывод на экран
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //Измененный код по заданию объединение date и time в 1 кнопку
        dateTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Сначала выбираем дату
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        dateAndTime.set(Calendar.YEAR, year);
                        dateAndTime.set(Calendar.MONTH, month);
                        dateAndTime.set(Calendar.DAY_OF_MONTH, day);

                        // После выбора даты сразу выбираем время
                        new TimePickerDialog(MainActivity.this, t,
                                dateAndTime.get(Calendar.HOUR_OF_DAY),
                                dateAndTime.get(Calendar.MINUTE), true).show();
                    }
                }, dateAndTime.get(Calendar.YEAR), dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //метод инициализации времени в Textview
    private void setInitialDate() {
    current.setText(DateUtils.formatDateTime(this,dateAndTime.getTimeInMillis(),DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_SHOW_YEAR|DateUtils.FORMAT_SHOW_TIME));
    }


    //слушатель даты
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR,year);
            dateAndTime.set(Calendar.MONTH,monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            setInitialDate();
        }
    };

    //слушатель времени
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            dateAndTime.set(Calendar.MINUTE,minute);
            setInitialDate();
        }
    };

}