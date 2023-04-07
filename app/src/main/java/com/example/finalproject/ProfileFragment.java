package com.example.finalproject;

import static android.app.Activity.RESULT_OK;

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

        // Xử lý sự kiện khi nhấn nút đăng xuất
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmLogoutDialog();
            }
        });

        btnOrderHistory = view.findViewById(R.id.btnOderHistory);

        btnOrderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderHistoryActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ORDER_HISTORY);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ORDER_HISTORY && resultCode == RESULT_OK) {
            // Thực hiện các hành động để quay trở lại trang FragmentProfile trước đó
        }
    }

    private void showConfirmLogoutDialog() {
        ConfirmLogoutDialogFragment dialogFragment = new ConfirmLogoutDialogFragment(new ConfirmLogoutDialogFragment.ConfirmLogoutDialogListener() {
            @Override
            public void onConfirmLogout() {
                // Thực hiện đăng xuất
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }

            @Override
            public void onCancelLogout() {
                // Không thực hiện đăng xuất
            }
        });
        dialogFragment.show(getChildFragmentManager(), "confirm_logout_dialog");
    }

}
