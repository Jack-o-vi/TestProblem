package com.example.bjorn.testproblem;

public class Testing {

    public static final int TASKS_MAX = 12;
    private int tasks;
    private int hours;

    public Testing(int tasks, int hours) {
        this.tasks = tasks;
        this.hours = hours;
    }

    public static int getTasksMax() {
        return TASKS_MAX;
    }
}
