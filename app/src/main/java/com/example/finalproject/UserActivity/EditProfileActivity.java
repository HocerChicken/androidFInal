package com.example.finalproject.UserActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.finalproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditProfileActivity extends AppCompatActivity {

    EditText edtFullName;
    EditText edtPhone;
    EditText edtEmail;
    EditText edtAddress;
    ImageView imgAvatar;
    Button btnExit;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        initUi();
        setUserInformation();
        initListener();
    }

    private void setUserInformation() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null) return;

        edtFullName.setText(user.getDisplayName());
        edtPhone.setText(user.getPhoneNumber());
        edtEmail.setText(user.getEmail());
        Glide.with(this).load(user.getPhotoUrl()).error(R.drawable.default_user_avatar).into(imgAvatar);
    }

    private void initListener() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();

                setResult(RESULT_OK);

                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onClickRequestPermission();
                Intent intentResult = new Intent();

                setResult(RESULT_OK);

                finish();
            }
        });
    }

//    private void onClickRequestPermission() {
//        MainActivity mainActivity ;
//        if(mainActivity == null)
//            return;
//
//        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
//            openGallery();
//            return;
//        }
//        if(this.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//            openGallery();
//        } else {
//            String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//            this.requestPermissions(permissions, MY_REQUEST_CODE);
//        }
//    }

    private void initUi() {
        imgAvatar = findViewById(R.id.img_avatar);
        edtFullName = findViewById(R.id.edtFullName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        btnExit = findViewById(R.id.btnExit);
        btnUpdate = findViewById(R.id.btnUpdate);
    }


}
