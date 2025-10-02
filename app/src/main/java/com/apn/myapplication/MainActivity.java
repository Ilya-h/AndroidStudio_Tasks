package com.apn.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etOrderAmount, etTipPercentage;
    TextView tvCalculateChaev, tvSumOrder, tvProcentChaev, tvResults,
            tvSumChaev, tvTipAmount, tvSumOrders, tvOrderAmount,tvTotal, tvTotalAmount;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etOrderAmount = findViewById(R.id.etOrderAmount);
        etTipPercentage = findViewById(R.id.etTipPercentage);
        tvCalculateChaev = findViewById(R.id.tvCalculateChaev);
        tvSumOrder = findViewById(R.id.tvSumOrder);
        tvProcentChaev = findViewById(R.id.tvProcentChaev);
        tvResults = findViewById(R.id.tvResults);
        tvSumChaev = findViewById(R.id.tvSumChaev);
        tvSumOrders = findViewById(R.id.tvSumOrders);
        tvTotal = findViewById(R.id.tvTotal);
        tvTipAmount = findViewById(R.id.tvTipAmount);
        tvOrderAmount = findViewById(R.id.tvOrderAmount);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получаем значения из полей ввода
                String orderAmountStr = etOrderAmount.getText().toString();
                String tipPercentageStr = etTipPercentage.getText().toString();

                // Проверяем, что поля не пустые
                if (TextUtils.isEmpty(orderAmountStr)) {
                    showToast("Введите сумму заказа");
                    return;
                }

                if (TextUtils.isEmpty(tipPercentageStr)) {
                    showToast("Введите процент чаевых");
                    return;
                }

                try {
                    // Преобразуем строки в числа
                    double orderAmount = Double.parseDouble(orderAmountStr);
                    double tipPercentage = Double.parseDouble(tipPercentageStr);

                    // Проверяем валидность введенных данных
                    if (orderAmount <= 0) {
                        showToast("Сумма заказа должна быть больше 0");
                        return;
                    }

                    if (tipPercentage < 0) {
                        showToast("Процент чаевых не может быть отрицательным");
                        return;
                    }

                    // Вычисляем сумму чаевых
                    double tipAmount = (orderAmount * tipPercentage) / 100;

                    // Вычисляем общий итог
                    double totalAmount = orderAmount + tipAmount;

                    // Форматируем числа для вывода (2 знака после запятой)
                    String formattedOrderAmount = String.format("%.2f", orderAmount);
                    String formattedTipAmount = String.format("%.2f", tipAmount);
                    String formattedTotalAmount = String.format("%.2f", totalAmount);

                    // Обновляем текстовые поля с результатами
                    tvOrderAmount.setText(formattedOrderAmount);
                    tvTipAmount.setText(formattedTipAmount);
                    tvTotalAmount.setText(formattedTotalAmount);

                } catch (NumberFormatException e) {
                    showToast("Пожалуйста, введите корректные числа");
                }
            }
            private void showToast(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}