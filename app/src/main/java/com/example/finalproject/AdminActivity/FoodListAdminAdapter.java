package com.example.finalproject.AdminActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.Food;
import com.example.finalproject.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class FoodListAdminAdapter extends ArrayAdapter<Food> {
    private Context context;
    private int resource;
    private ArrayList<Food> foodList;

    public FoodListAdminAdapter(Context context, int resource, ArrayList<Food> foodList) {
        super(context, resource, foodList);
        this.context = context;
        this.resource = resource;
        this.foodList = foodList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(resource, parent, false);

            holder = new ViewHolder();
            holder.ivFood = view.findViewById(R.id.ivFood);
            holder.tvFoodName = view.findViewById(R.id.tvFoodName);
            holder.tvFoodPrice = view.findViewById(R.id.tvFoodPrice);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Food food = foodList.get(position);

        holder.ivFood.setImageResource(food.getImage());
        holder.tvFoodName.setText(food.getName());

        NumberFormat formatter = NumberFormat.getInstance();
        String formattedPrice = formatter.format(food.getPrice());
        holder.tvFoodPrice.setText(formattedPrice);
        return view;
    }

    static class ViewHolder {
        ImageView ivFood;
        TextView tvFoodName;
        TextView tvFoodPrice;
    }
}
