package com.saikat.emsemployeetracker.Models;

public class TaskModel {

    String taskName;
    String taskDescription;
    String duedate;
    String taskPriority;

    public TaskModel(String taskName,
                     String taskDescription,
                     String duedate,
                     String taskPriority
    ){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.duedate = duedate;
        this.taskPriority = taskPriority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }
}
