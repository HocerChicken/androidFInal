package com.example.finalproject.AdminActivity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.finalproject.Food;
import com.example.finalproject.R;

import java.util.ArrayList;

public class HomeAdminFragment extends Fragment {
    private ListView lvFoodAdmin;
    private FoodListAdminAdapter foodAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_admin, container, false);
        lvFoodAdmin = view.findViewById(R.id.lvFoodAdmin);

        // Tạo danh sách các món ăn
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Món 1", R.drawable.com_tam, 100000));
        foodList.add(new Food("Món 2", R.drawable.com_tam, 200000));
        foodList.add(new Food("Món 3", R.drawable.com_tam, 150000));
        foodList.add(new Food("Món 4", R.drawable.com_tam, 180000));

        // Khởi tạo FoodAdapter
        foodAdapter = new FoodListAdminAdapter(getContext(), foodList);

        // Gán FoodAdapter cho ListView
        lvFoodAdmin.setAdapter(foodAdapter);

        // Các xử lý logic của fragment home_admin.xml ở đây
        return view;
    }
}


