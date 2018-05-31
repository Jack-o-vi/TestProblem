package com.example.bjorn.testproblem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String INVALID = "Invalid number";
    public static final String YES = "Yes";
    public static final String NO = "No";
    public static final String WRONG = "Wrong number format";
    public static final int TASKS_MAX = 12;
    private static final String TAG = "[MainActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /**
     * @param tasks input tasks
     * @param hours input total hours
     * @return result string
     */
    public String perform(String tasks, String hours) {
        int minF = 1;
        int maxF = 11;
        int minH = 1;
        int maxH = 24;
        int iterTime = 55;
        int minInH = 60;

        try {
            // Tasks per first hour
            int f = Integer.parseInt(tasks);
            // Total amount of hours
            int h = Integer.parseInt(hours);

            // Check the condition of right inputs 1 <= tasks <= 11 and 1<= hours <= 24
            if (!(minF <= f && f <= maxF && minH <= h && h <= maxH)) return INVALID;

            // Calculate how many tasks remain
            int remain = TASKS_MAX - f;
            int result = 0;

            // Until all tasks are done
            result = (remain - 1) * iterTime;
            // temporary logging
            Log.d(TAG, "Result min: " + result + " Min: " + ((h - 1) * minInH));

            // Check if amount of spent time on remaining tasks is less or equals to the Total time minus 1 first hour
            if (result <= ((h - 1) * minInH))
                return YES;
            else return NO;


        } catch (NumberFormatException e) {
            e.printStackTrace();
            return WRONG;
        }


    }

    public void onclick(View v) {
        EditText etTasks = findViewById(R.id.etTasks);
        EditText etHours = findViewById(R.id.etHours);
        TextView tvResult = findViewById(R.id.tvResult);
        String result = perform(etTasks.getText().toString(), etHours.getText().toString());
        if (result != null) {
            tvResult.setText(result);
        }
    }
}
