package com.example.bjorn.testproblem;

import java.util.Scanner;

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

    public static void main(String[] args) {


        int minF = 1;
        int maxF = 11;
        int minH = 1;
        int maxH = 24;
        int iterTime = 55;
        int minInH = 60;
        try (Scanner sc = new Scanner(System.in)) {
            int f;
            int h;
            do {
                f = sc.nextInt();
                h = sc.nextInt();
            } while (!(minF <= f && f <= maxF && minH <= h && h <= maxH));

            Testing t = new Testing(f, h);

            int remain = Testing.getTasksMax() - f;
            int result = iterTime;
            for (int i = 0; i < remain-1; i++) {
                result += result;
            }

            if (result <= ((h - 1) * 60))
                System.out.println("Yes");
            else System.out.println("No");

        }

    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}
