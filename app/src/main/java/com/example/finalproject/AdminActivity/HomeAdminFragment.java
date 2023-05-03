package com.example.finalproject.AdminActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Model.Food;
import com.example.finalproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeAdminFragment extends Fragment {
    private ListView lvFoodAdmin;
    private FoodListAdminAdapter foodAdapter;
    private List<Food> foodList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_admin, container, false);
        lvFoodAdmin = view.findViewById(R.id.lvFoodAdmin);

        // Tạo danh sách các món ăn mặc định
        // addListFoodDefault();

        // Lấy list food từ database realtime;
        getListFoodsFromRealtimeDatabase();

        // Khởi tạo FoodAdapter
        foodAdapter = new FoodListAdminAdapter(getContext(), foodList);

        // Gán FoodAdapter cho ListView
        lvFoodAdmin.setAdapter(foodAdapter);

        // Các xử lý logic của fragment home_admin.xml ở đây
        return view;
    }

    private void getListFoodsFromRealtimeDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_foods");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Food food = dataSnapshot.getValue(Food.class);
                    foodList.add(food);
                }
                foodAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addListFoodDefault() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_foods");
        foodList.add(new Food("Cơm sườn bì chả ", R.drawable.com_tam, 30000));
        foodList.add(new Food("Cơm sườn", R.drawable.com_suon, 30000));
        foodList.add(new Food("Cơm gà", R.drawable.com_ga, 30000));
        foodList.add(new Food("Cơm cá mú", R.drawable.com_ca_mu, 30000));
        foodList.add(new Food("Cơm gà xối mỡ", R.drawable.com_ga_xoi_mo, 50000));
        foodList.add(new Food("Bún bò", R.drawable.bun_bo, 50000));
        foodList.add(new Food("Bún riêu", R.drawable.bun_rieu, 50000));
        foodList.add(new Food("Phở", R.drawable.pho, 50000));
        myRef.setValue(foodList);
    }
}


