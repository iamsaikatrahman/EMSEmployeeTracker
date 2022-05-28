package com.saikat.emsemployeetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.saikat.emsemployeetracker.databinding.ActivityMyProfileBinding;

public class MyProfileActivity extends DrawerBaseActivity {

    ActivityMyProfileBinding activityMyProfileBinding;

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyProfileBinding = ActivityMyProfileBinding.inflate(getLayoutInflater());

        setContentView(activityMyProfileBinding.getRoot());
        allocateActivityTitle("My Profile");

        logout = findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyProfileActivity.this, "Clicked the Logout Button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}