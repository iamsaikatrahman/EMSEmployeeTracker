package com.saikat.emsemployeetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.saikat.emsemployeetracker.databinding.ActivityAddNewTaskBinding;
import com.saikat.emsemployeetracker.databinding.ActivityMyProfileBinding;

public class AddNewTaskActivity extends DrawerBaseActivity {
    ActivityAddNewTaskBinding activityAddNewTaskBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddNewTaskBinding = ActivityAddNewTaskBinding.inflate(getLayoutInflater());

        setContentView(activityAddNewTaskBinding.getRoot());
        allocateActivityTitle("Add New Task");
        //getSupportActionBar().setTitle("Add New Task");
    }
}