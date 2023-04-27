package com.example.finalproject.AdminActivity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.finalproject.OrderHistory;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderListAdminFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_admin, container, false);

        ListView lvOrderHistoryAdmin = view.findViewById(R.id.lvOrderHistoryAdmin);
        OrderHistoryAdminAdapter adapter = new OrderHistoryAdminAdapter(getActivity(), R.layout.order_history_list, getOrderHistoryList());
        lvOrderHistoryAdmin.setAdapter(adapter);

        return view;
    }

    private List<OrderHistory> getOrderHistoryList() {
        // Lấy danh sách đơn hàng từ nguồn dữ liệu của bạn
        List<OrderHistory> orderHistoryList = new ArrayList<>();

        // Thêm các đơn hàng vào danh sách
        // ...
        orderHistoryList.add(new OrderHistory(1, 50.0, new ArrayList<>(), new Date(), "John Doe", "123456789", "123 Main St","đã nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "chưa nhận hàng"));
        orderHistoryList.add(new OrderHistory(2, 30.0, new ArrayList<>(), new Date(), "Jane Doe", "987654321", "456 Elm St", "đã giao hàng"));

        return orderHistoryList;
    }
}

