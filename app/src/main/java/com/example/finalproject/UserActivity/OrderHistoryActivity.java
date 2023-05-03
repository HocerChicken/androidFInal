package com.example.finalproject.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalproject.Model.OrderHistory;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.Date;

public class OrderHistoryActivity extends AppCompatActivity {
    private ListView listView;
    private OrderHistoryAdapter adapter;
    private ArrayList<OrderHistory> orderHistoryList;

    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_history);

        // Tạo mock data
        orderHistoryList = new ArrayList<>();
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã nhận hàng"));
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã nhận hàng"));
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã nhận hàng"));
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã nhận hàng"));
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã nhận hàng"));
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã nhận hàng"));

        // Tạo adapter và thiết lập cho ListView
        adapter = new OrderHistoryAdapter(this, orderHistoryList);
        listView = findViewById(R.id.lvOrderHistory);
        listView.setAdapter(adapter);

        btnExit = findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
