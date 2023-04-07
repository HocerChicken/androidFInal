package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryAdapter extends ArrayAdapter<OrderHistory> {
    private Context context;
    private ArrayList<OrderHistory> orderHistoryList;

    public OrderHistoryAdapter(Context context, ArrayList<OrderHistory> orderHistoryList) {
        super(context, 0, orderHistoryList);
        this.context = context;
        this.orderHistoryList = orderHistoryList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderHistory orderHistory = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.order_history_list, parent, false);
        }

        // Ánh xạ các view trong layout
        TextView tvOrderID = convertView.findViewById(R.id.tvOrderID);
        TextView tvStatus = convertView.findViewById(R.id.tvStatus);
        ImageButton btnOrderInfo = convertView.findViewById(R.id.btnOrderInfo);

        // Hiển thị dữ liệu
        tvOrderID.setText(String.valueOf(orderHistory.getOrderCode()));
        tvStatus.setText("chưa nhận hàng");

        return convertView;
    }
}
