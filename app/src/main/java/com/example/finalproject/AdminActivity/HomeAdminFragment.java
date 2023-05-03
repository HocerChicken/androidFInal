package com.example.finalproject.AdminActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private static final int REQUEST_CODE = 1;
    private Button btnAddFood;
    private EditText edtFoodName;
    private EditText edtPrice;
    private EditText edtImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_admin, container, false);
        lvFoodAdmin = view.findViewById(R.id.lvFoodAdmin);
        btnAddFood = view.findViewById(R.id.btnAdd);
        edtFoodName = view.findViewById(R.id.edtFoodName);
        edtPrice = view.findViewById(R.id.edtFoodPrice);
        edtImg = view.findViewById(R.id.edtFoodPicturePath);

        // Tạo danh sách các món ăn mặc định
        addListFoodDefault();

        // Khởi tạo FoodAdapter
        foodAdapter = new FoodListAdminAdapter(getContext(), foodList, this);

        // Gán FoodAdapter cho ListView
        lvFoodAdmin.setAdapter(foodAdapter);

        // Các xử lý logic của fragment home_admin.xml ở đây

        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idNew = foodList.size();
                String nameNew = edtFoodName.getText().toString().trim();
                String priceNew = edtPrice.getText().toString().trim();
                String imgNew = edtImg.getText().toString().trim();
                Food food = new Food(nameNew, Integer.parseInt(priceNew), Integer.parseInt(imgNew));
                onclickAddFood(food, idNew);
            }
        });
        // Lấy list food từ database realtime;
        getListFoodsFromRealtimeDatabase();
        return view;
    }

    private void onclickAddFood(Food food, int idNew) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_foods");

        myRef.child(String.valueOf(idNew)).setValue(food, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null) {
                    Toast.makeText(getContext(), "Food added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed to add food", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getListFoodsFromRealtimeDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_foods");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                foodList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            foodList.clear();
            getListFoodsFromRealtimeDatabase();
            Toast.makeText(getContext(), "Edit Food successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void addListFoodDefault() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_foods");
        foodList.add(new Food("Cơm sườn bì chả ", 30000, R.drawable.com_tam));
        foodList.add(new Food("Cơm sườn", 30000, R.drawable.com_suon));
        foodList.add(new Food("Cơm gà", 30000, R.drawable.com_ga));
        foodList.add(new Food("Cơm cá mú", 30000, R.drawable.com_ca_mu));
        foodList.add(new Food("Cơm gà xối mỡ", 50000, R.drawable.com_ga_xoi_mo));
        foodList.add(new Food("Bún bò", 50000, R.drawable.bun_bo));
        foodList.add(new Food("Bún riêu", 50000, R.drawable.bun_rieu));
        foodList.add(new Food("Phở", 50000, R.drawable.pho));
        myRef.setValue(foodList);
    }
}


