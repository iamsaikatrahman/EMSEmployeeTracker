package com.saikat.emsemployeetracker.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saikat.emsemployeetracker.Models.TaskModel;
import com.saikat.emsemployeetracker.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.viewHolder>{

    ArrayList<TaskModel> list;
    Context context;

    public TaskAdapter(ArrayList<TaskModel> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.task_card, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TaskModel taskModel = list.get(position);
        holder.taskName.setText(taskModel.getTaskName());
        holder.description.setText(taskModel.getTaskDescription());
        holder.duedate.setText(taskModel.getDuedate());
        holder.taskPriority.setText(taskModel.getTaskPriority());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        TextView description;
        TextView duedate;
        TextView taskPriority;
        public viewHolder (@NonNull View itemview){
            super(itemview);
            taskName = itemview.findViewById(R.id.card_task_title);
            description = itemview.findViewById(R.id.card_task_description);
            duedate = itemview.findViewById(R.id.card_task_due_date);
            taskPriority = itemview.findViewById(R.id.card_task_description);

        }
    }
}
