package com.saikat.emsemployeetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button btnlogin;
    AutoCompleteTextView autoCompleteTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();
        btnlogin = findViewById(R.id.btn_login);

        //String languages = getResources().getStringArray(R.array.programming_languages);

        ArrayAdapter arrayAdapter = new ArrayAdapter(LoginActivity.this,
                R.layout.dropdown_item,
                getResources().getStringArray(R.array.programming_languages));
        autoCompleteTV = findViewById(R.id.autoCompleteTextView);
        autoCompleteTV.setAdapter(arrayAdapter);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MyFeedActivity.class);
                startActivity(intent);
            }
        });

    }
}