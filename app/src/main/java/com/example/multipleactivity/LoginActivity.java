package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextOne = findViewById(R.id.firstNumberEditText);
        EditText editTextTwo = findViewById(R.id.secondNumberEditText);
        Button addBtn = findViewById(R.id.addButton);
        TextView resultTv = findViewById(R.id.resultTextView);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
//                    String valueOne = editTextOne.getText().toString();
//                    String valueTwo = editTextTwo.getText().toString();
//
//                    if (valueOne.length() == 0 && valueTwo.length() == 0) {
//                        Snackbar.make(view, "Please enter numbers", Snackbar.LENGTH_LONG).show();
//                        return;
//                    }
//
//                    int result = Integer.parseInt(valueOne) + Integer.parseInt(valueTwo);
//                    resultTv.setText("Result: " + result);
//                } catch (Exception e) {
//                    Log.d("error", "" + e);
//                }
            }
        });
    }
}