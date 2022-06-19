package com.saikat.emsemployeetracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ArrayAdapter;
import android.widget.Button;



import com.saikat.emsemployeetracker.Models.TaskModel;
import com.saikat.emsemployeetracker.databinding.ActivityMyFeedBinding;

import java.util.ArrayList;

public class MyFeedActivity extends DrawerBaseActivity {
    ActivityMyFeedBinding activityMyFeedBinding;

    Button btn;
    ArrayAdapter taskArrayAdapter;
    AddNewTaskDBHelper addNewTaskDBHelper;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyFeedBinding = ActivityMyFeedBinding.inflate(getLayoutInflater());
        setContentView(activityMyFeedBinding.getRoot());
        allocateActivityTitle("My Feed");

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}


        if(!gps_enabled) {
            // notify user
            new AlertDialog.Builder(context)
                    .setMessage("gps network not enabled")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                            context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        }




    }

}

