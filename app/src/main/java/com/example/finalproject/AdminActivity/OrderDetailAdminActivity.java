package com.example.finalproject.AdminActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.Food;
import com.example.finalproject.FoodListInOrderDetailAdapter;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailAdminActivity extends AppCompatActivity {

    Button btnStatus;
    Button btnExit;
    ListView lvOrderHistoryAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_admin);

        btnStatus = findViewById(R.id.btnStatus);
        btnExit = findViewById(R.id.btnExit);
        lvOrderHistoryAdmin = findViewById(R.id.lvOrderHistoryAdmin);


        // Lấy dữ liệu từ Intent (nếu có)
        Intent intent = getIntent();
        int orderCode = intent.getIntExtra("orderCode", 0);
        double totalAmount = intent.getDoubleExtra("totalAmount", 0.0);
        // ...

        // Tạo danh sách món ăn (có thể lấy từ Intent hoặc từ nguồn dữ liệu khác)
        List<Food> foodList = new ArrayList<>();
        // Thêm các món ăn vào danh sách
        foodList.add(new Food("Cơm Tấm", R.drawable.com_tam, 25000,3));

        // Tạo adapter cho lvOrderHistory
        FoodListInOrderDetailAdapter adapter = new FoodListInOrderDetailAdapter(this, foodList);
        lvOrderHistoryAdmin.setAdapter(adapter);


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
