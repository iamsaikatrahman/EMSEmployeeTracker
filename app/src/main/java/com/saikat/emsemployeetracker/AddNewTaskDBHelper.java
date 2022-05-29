package com.saikat.emsemployeetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.saikat.emsemployeetracker.Models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class AddNewTaskDBHelper extends SQLiteOpenHelper {

    public static final String TASK_TABLE = "TASK_TABLE";
    public static final String COLUMN_TASK_NAME = "TASK_NAME";
    public static final String COLUMN_TASK_DESCRIPTION = "TASK_DESCRIPTION";
    public static final String COLUMN_DUE_DATE = "DUE_DATE";
    public static final String COLUMN_TASK_PRIORITY = "TASK_PRIORITY";
    public static final String COLUMN_ID = "ID";

    public AddNewTaskDBHelper(@Nullable Context context) {
        super(context, "task.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TASK_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASK_NAME + " TEXT, " + COLUMN_TASK_DESCRIPTION + " TEXT, " + COLUMN_DUE_DATE + " TEXT, " + COLUMN_TASK_PRIORITY + " TEXT)";
        db.execSQL(createTableStatement);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       // db.execSQL("drop Table if exists Taskdetails");
    }

    public boolean addOne(TaskModel taskModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TASK_NAME, taskModel.getTaskName());
        cv.put(COLUMN_TASK_DESCRIPTION, taskModel.getTaskDescription());
        cv.put(COLUMN_DUE_DATE, taskModel.getDuedate());
        cv.put(COLUMN_TASK_PRIORITY, taskModel.getTaskPriority());

        long insert = db.insert(TASK_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteOne(TaskModel taskModel){
//        find taskmodel in the database . if it found delete it and return true;
//        if it is not found, return false;
        SQLiteDatabase db =  this.getWritableDatabase();
        String queryString = "DELETE FROM " + TASK_TABLE + " WHERE " + COLUMN_ID + " = " + taskModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }

    public List<TaskModel> getEveryone(){
        List<TaskModel> returnList = new ArrayList<>();


        String queryString = "SELECT * FROM " + TASK_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do {
                int taskID = cursor.getInt(0);
                String taskName = cursor.getString(1);
                String taskDescription = cursor.getString(2);
                String dueDate = cursor.getString(3);
                String taskPriority = cursor.getString(4);


                TaskModel newTask = new TaskModel(taskID, taskName, taskDescription, dueDate, taskPriority);
                returnList.add(newTask);
            }while (cursor.moveToNext());
        }else{

        }
        cursor.close();
        db.close();
        return returnList;

    }


}
