package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button goBackBtn = findViewById(R.id.goBackBtn);
        TextView userInfoTv = findViewById(R.id.userInfoTextView);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        int age = i.getIntExtra("agesss", 0);
        String email = i.getStringExtra("email");

        String data = "Name: "+name +"\nAge: "+ age +"\nEmail: "+email ;

        Log.d("Value from login: ", data);
        userInfoTv.setText(data);

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}