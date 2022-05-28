package com.saikat.emsemployeetracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.saikat.emsemployeetracker.databinding.ActivityAddNewTaskBinding;
import com.saikat.emsemployeetracker.databinding.ActivityMyProfileBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class AddNewTaskActivity extends DrawerBaseActivity {
    ActivityAddNewTaskBinding activityAddNewTaskBinding;

    private DatePickerDialog datePickerDialog;
    private Button btn_datePicker, btn_save, btn_cancel;
    private EditText et_taskname, et_taskdescription;
    private Spinner task_priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddNewTaskBinding = ActivityAddNewTaskBinding.inflate(getLayoutInflater());

        setContentView(activityAddNewTaskBinding.getRoot());
        allocateActivityTitle("Add New Task");


        initDatePicker();
        btn_datePicker = findViewById(R.id.btn_datePicker);
        btn_save = findViewById(R.id.btn_save);
        btn_cancel = findViewById(R.id.btn_cancel);
        task_priority = findViewById(R.id.sp_task_priority);
        et_taskname = findViewById(R.id.et_task_name);
        et_taskdescription = findViewById(R.id.et_task_details);
        btn_datePicker.setText(getTodayDate());

        ArrayList<String> options=new ArrayList<String>();

        options.add("Task Priority 1");
        options.add("Task Priority 2");
        options.add("Task Priority 3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options);
        task_priority.setAdapter(adapter);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddNewTaskActivity.this,
                        "Task Name: "+ et_taskname.getText() +
                                "\nTask Description: "+et_taskdescription.getText() +
                        "\nDue Date: "+btn_datePicker.getText() +
                        "\nTask Prority: "+task_priority.getSelectedItem().toString(),  Toast.LENGTH_LONG).show();
            }
        });

    }

    private String getTodayDate() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                btn_datePicker.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormate(month) + " " + day + ", " + year;
    }

    private String getMonthFormate(int month) {
        if (month == 1) {
            return "JAN";
        }
        if (month == 2) {
            return "FEB";
        }
        if (month == 3) {
            return "MAR";
        }
        if (month == 4) {
            return "APR";
        }
        if (month == 5) {
            return "MAY";
        }
        if (month == 6) {
            return "JUN";
        }
        if (month == 7) {
            return "JUL";
        }
        if (month == 8) {
            return "AUG";
        }
        if (month == 9) {
            return "SEP";
        }
        if (month == 10) {
            return "OCT";
        }
        if (month == 11) {
            return "NOV";
        }
        if (month == 12) {
            return "DEC";
        }
        return "JAN";
    }

    ;

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}