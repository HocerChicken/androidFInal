package com.example.finalproject.UserActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.finalproject.Food;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ListView listView;
    private List<Food> foodList;
    private FoodListAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.lvFood);
        foodList = new ArrayList<>();

        // lấy dữ liệu vào danh sách
        foodList.add(new Food("Cơm Tấm", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Cơm Gà", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Bò", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Mì Xào", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Thịt Nướng", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Bò", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Mì Xào", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Thịt Nướng", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Thịt Nướng", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Bò", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Mì Xào", R.drawable.com_tam, 25000,0));
        foodList.add(new Food("Bún Thịt Nướng", R.drawable.com_tam, 25000,0));

        // Thiết lập Adapter
        adapter = new FoodListAdapter(getActivity(), foodList);
        listView.setAdapter(adapter);
        return view;
    }

}
