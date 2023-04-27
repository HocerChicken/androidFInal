package com.example.finalproject.UserActivity;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.LoginActivity;
import com.example.finalproject.R;


public class ProfileFragment extends Fragment {
    public static final int REQUEST_CODE_ORDER_HISTORY = 1;

    public ProfileFragment() {
        // Required empty public constructor
    }

    TextView tvUserFullName;
    ImageButton btnEditProfile;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvAddress;
    Button btnOrderHistory;
    Button btnLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Ánh xạ các View trong fragment_profile.xml
        btnLogout = view.findViewById(R.id.btnLogout);

        btnOrderHistory = view.findViewById(R.id.btnOderHistory);

        btnEditProfile = view.findViewById(R.id.btnEditProfile);

        btnOrderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderHistoryActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ORDER_HISTORY);
            }
        });

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình chỉnh sửa thông tin cá nhân
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn nút đăng xuất
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo dialog xác nhận
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Bạn có chắc chắn muốn đăng xuất?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Thực hiện đăng xuất và chuyển sang trang đăng nhập
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Không thực hiện đăng xuất
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        // Trả về View của Fragment
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ORDER_HISTORY && resultCode == RESULT_OK) {
            // Thực hiện các hành động để quay trở lại trang FragmentProfile trước đó
        }
    }

}
