package com.example.finalproject.UserActivity;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.finalproject.LoginActivity;
import com.example.finalproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {
    public static final int REQUEST_CODE_ORDER_HISTORY = 1;

    public ProfileFragment() {
        // Required empty public constructor
    }

    ImageView imgAvatar;
    TextView tvUserFullName;
    ImageButton btnEditProfile;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvAddress;
    Button btnOrderHistory;
    Button btnLogout;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Ánh xạ các View trong fragment_profile.xml
        initUi();
        showUserInformation();
        initListener();
        // Trả về View của Fragment
        return mView;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ORDER_HISTORY && resultCode == RESULT_OK) {
            // Thực hiện các hành động để quay trở lại trang FragmentProfile trước đó
        }
    }

    private void initUi(){
        imgAvatar = mView.findViewById(R.id.img_avatar);
        tvUserFullName= mView.findViewById(R.id.tvUserFullName);
        tvPhone = mView.findViewById(R.id.tvPhone);
        tvEmail = mView.findViewById(R.id.tvEmail);
        tvAddress = mView.findViewById(R.id.tvAddress);
        btnLogout = mView.findViewById(R.id.btnLogout);
        btnOrderHistory = mView.findViewById(R.id.btnOderHistory);
        btnEditProfile = mView.findViewById(R.id.btnEditProfile);
    }

    private void initListener(){
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
              onClickLogout();
            }
        });
    }

    private void onClickLogout() {
        // Tạo dialog xác nhận
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Bạn có chắc chắn muốn đăng xuất?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Thực hiện đăng xuất và chuyển sang trang đăng nhập
                FirebaseAuth.getInstance().signOut();
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

    public void showUserInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String name = user.getDisplayName();
        String email = user.getEmail();
        String phone = user.getPhoneNumber();
        Uri photoUri = user.getPhotoUrl();

        if(name == null){
            tvUserFullName.setVisibility(View.GONE);
        } else {
            tvUserFullName.setVisibility(View.VISIBLE);
            tvUserFullName.setText(name);
        }
        if(phone == null){
            tvPhone.setVisibility(View.GONE);
        } else {
            tvPhone.setVisibility(View.VISIBLE);
            tvPhone.setText(name);
        }

        tvEmail.setText(email);
        Glide.with(this).load(photoUri).error(R.drawable.default_user_avatar).into(imgAvatar);
    }
}
