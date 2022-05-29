package com.saikat.emsemployeetracker;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.saikat.emsemployeetracker.Adaptar.TaskAdapter;
import com.saikat.emsemployeetracker.Models.TaskModel;
import com.saikat.emsemployeetracker.databinding.ActivityMyFeedBinding;

import java.util.ArrayList;

public class MyFeedActivity extends DrawerBaseActivity {
    ActivityMyFeedBinding activityMyFeedBinding;

    Button btn;
    ArrayAdapter taskArrayAdapter;
    AddNewTaskDBHelper addNewTaskDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyFeedBinding = ActivityMyFeedBinding.inflate(getLayoutInflater());
        setContentView(activityMyFeedBinding.getRoot());
        allocateActivityTitle("My Feed");

        addNewTaskDBHelper = new AddNewTaskDBHelper(MyFeedActivity.this);
        ShowTaskOnListView(addNewTaskDBHelper);

        ArrayList<TaskModel> list = new ArrayList<>();

//        TaskAdapter adapter = new TaskAdapter(list, MyFeedActivity.this);
//        activityMyFeedBinding.taskRecyclerView.setAdapter(adapter);
//
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        activityMyFeedBinding.taskRecyclerView.setLayoutManager(linearLayoutManager);



    }
    private void ShowTaskOnListView(AddNewTaskDBHelper addNewTaskDBHelper) {
        taskArrayAdapter = new ArrayAdapter<TaskModel>(MyFeedActivity.this, R.layout.task_card, addNewTaskDBHelper.getEveryone());
       activityMyFeedBinding.taskListView.setAdapter(taskArrayAdapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyFeedActivity.this);
//        activityMyFeedBinding.taskRecyclerView.setLayoutManager(linearLayoutManager);
    }
}

