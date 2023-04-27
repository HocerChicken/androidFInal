package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailActivity extends AppCompatActivity {

    Button btnStatus;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);

        btnStatus = findViewById(R.id.btnStatus);
        btnExit = findViewById(R.id.btnExit);

        // Lấy dữ liệu từ Intent (nếu có)
        Intent intent = getIntent();
        int orderCode = intent.getIntExtra("orderCode", 0);
        double totalAmount = intent.getDoubleExtra("totalAmount", 0.0);
        // ...

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }

}
