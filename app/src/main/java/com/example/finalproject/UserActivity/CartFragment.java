package com.example.finalproject.UserActivity;

import static com.example.finalproject.UserActivity.MainActivity.database;
import static com.example.finalproject.UserActivity.MainActivity.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Model.Food;
import com.example.finalproject.Model.OrderHistory;
import com.example.finalproject.Model.User;
import com.example.finalproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CartFragment extends Fragment {
    private ListView listView;
    private FoodListInCartAdapter adapter;
    public static int total;
    public static List<Food> cart = new ArrayList<>();
    public static TextView tvTotal;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        listView = view.findViewById(R.id.lvFoodInCart);
        Button btnBook = view.findViewById(R.id.btnConfirm);
        tvTotal = view.findViewById(R.id.textView4);

        cart = new ArrayList<>();

        // Thêm dữ liệu vào danh sách
        getListFoodsInCartFromRealtimeDatabase();

        // Thiết lập Adapter
        adapter = new FoodListInCartAdapter(getActivity(), cart);
        listView.setAdapter(adapter);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBook();
            }
        });
        return view;
    }

    private void onClickBook() {
        List<OrderHistory> list_orders = new ArrayList<>();
//            public OrderHistory(int orderCode, double totalAmount, ArrayList<Food> foodList,
//                Date orderDate, String userFullName, String phoneNumber, String address, String status) {
//            this.orderCode = orderCode;
//            this.totalAmount = totalAmount;
//            this.foodList = foodList;
//            this.orderDate = orderDate;
//            this.userFullName = userFullName;
//            this.phoneNumber = phoneNumber;
//            this.address = address;
//            this.status = status;
//        }

        DatabaseReference userRef  = database.getReference("list_users/" + user.getUid());
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.getValue(User.class);

                    OrderHistory order = new OrderHistory(new Random().nextInt(101)
                                , total, cart, new Date(), user.getUserFullName(), user.getPhoneNumber(), user.getAddress(), "Chua nhan hang");
                    Toast.makeText(getContext(), order.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        //OrderHistory order = new OrderHistory(new Random().nextInt(101), total, cart, );

        //list_orders.add(order);

//        DatabaseReference myRef = database.getReference("list_users/"+user.getUid()+"/carts");
//        myRef.removeValue();
//        total = 0;
//        cart.clear();
    }

    private void getListFoodsInCartFromRealtimeDatabase() {
        DatabaseReference myRef = database.getReference("list_users/"+user.getUid()+"/carts");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cart.clear();
                total = 0;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Food food = dataSnapshot.getValue(Food.class);
                    total += food.getQuantity() * food.getPrice();
                    cart.add(food);
                }
                tvTotal.setText(String.valueOf(total));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
