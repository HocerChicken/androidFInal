package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrderHistoryAdminAdapter extends ArrayAdapter<OrderHistory> {

    private int layoutResource;

    public OrderHistoryAdminAdapter(@NonNull Context context, int resource, @NonNull List<OrderHistory> objects) {
        super(context, resource, objects);
        layoutResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layoutResource, null);
        }

        OrderHistory orderHistory = getItem(position);
        if (orderHistory != null) {
            TextView tvOrderID = convertView.findViewById(R.id.tvOrderID);
            TextView tvStatus = convertView.findViewById(R.id.tvStatus);

            // Thiết lập giá trị cho các View trong order_history_list.xml
            tvOrderID.setText(String.valueOf(orderHistory.getOrderCode()));
            tvStatus.setText("Chưa giao hàng");
        }

        return convertView;
    }
}
