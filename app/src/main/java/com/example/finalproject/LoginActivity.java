package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(username.equals("")){
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập Username.", Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập Password.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.length() < 6){
                        Toast.makeText(LoginActivity.this, "Mật khẩu phải lớn hơn 6 ký tự.", Toast.LENGTH_SHORT).show();
                    } else if (username.equals("user") && password.equals("123456")) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else if (username.equals("admin") && password.equals("123456")) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập admin thành công.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivityAdmin.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Username hoặc Password không chính xác.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivityForResult(intent, 12345);
            }
        });
    }
}