package com.saikat.emsemployeetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.saikat.emsemployeetracker.Adaptar.TaskAdapter;
import com.saikat.emsemployeetracker.Models.TaskModel;
import com.saikat.emsemployeetracker.databinding.ActivityMyFeedBinding;
import com.saikat.emsemployeetracker.databinding.ActivityMyProfileBinding;

import java.util.ArrayList;

public class MyFeedActivity extends DrawerBaseActivity {
    ActivityMyFeedBinding activityMyFeedBinding;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyFeedBinding = ActivityMyFeedBinding.inflate(getLayoutInflater());
        setContentView(activityMyFeedBinding.getRoot());
        allocateActivityTitle("My Feed");

        ArrayList<TaskModel> list = new ArrayList<>();
        list.add(new TaskModel(
                "Task Name 1",
                "Task Description Task Description Task Description Task Description Task Description Task Description Task Description Task Description Task Description Task Description Task Description Task Description ",
                "May 29, 2022",
                "Task Priority 2"

        ));
        list.add(new TaskModel(
                "Task Name 2",
                "Task Description 2",
                "May 30, 2022",
                "Task Priority 3"

        ));
        list.add(new TaskModel(
                "Task Name 3",
                "Task Description 3",
                "May 31, 2022",
                "Task Priority 1"

        ));


        TaskAdapter adapter = new TaskAdapter(list, MyFeedActivity.this);
        activityMyFeedBinding.taskRecyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityMyFeedBinding.taskRecyclerView.setLayoutManager(linearLayoutManager);



    }
}