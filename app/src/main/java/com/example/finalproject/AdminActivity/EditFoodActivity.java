package com.example.finalproject.AdminActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

public class EditFoodActivity extends AppCompatActivity {

    Button btnExit;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_food);

        btnExit = findViewById(R.id.btnExit);
        btnUpdate = findViewById(R.id.btnUpdate);

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
                Intent intentResult = new Intent();

                setResult(RESULT_OK);

                finish();
            }
        });
    }

}
