package com.example.finalproject.AdminActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.Model.Food;
import com.example.finalproject.R;

import java.text.NumberFormat;
import java.util.List;

public class FoodListAdminAdapter extends ArrayAdapter<Food> {
    private Context context;
    private List<Food> foodList;

    public FoodListAdminAdapter(Context context, List<Food> foodList) {
        super(context, R.layout.foods_list_admin, foodList);
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.foods_list_admin, parent, false);

        Food food = foodList.get(position);

        // Ánh xạ dữ liệu vào các View trong item layout
        ImageView ivFoodImage = convertView.findViewById(R.id.ivFood);
        TextView tvFoodName = convertView.findViewById(R.id.tvFoodName);
        TextView tvFoodPrice = convertView.findViewById(R.id.tvFoodPrice);
        ImageButton btnUpdateFood = convertView.findViewById(R.id.btnUpdateFood);
        ImageButton btnDeleteFood = convertView.findViewById(R.id.btnDeleteFood);

        NumberFormat formatter = NumberFormat.getInstance();
        String formattedPrice = formatter.format(food.getPrice());
        tvFoodPrice.setText(formattedPrice);

        ivFoodImage.setImageResource(food.getImage());
        tvFoodName.setText(food.getName());

        btnUpdateFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển đến trang EditFoodActivity
                Intent intent = new Intent(getContext(), EditFoodActivity.class);
                getContext().startActivity(intent);
            }
        });

        return convertView;


    }
}
