package com.example.bjorn.testproblem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "[MainActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public String perform(String tasks, String hours) {
        int minF = 1;
        int maxF = 11;
        int minH = 1;
        int maxH = 24;
        int iterTime = 55;
        int minInH = 60;
        try {
            int f = Integer.parseInt(tasks);
            int h = Integer.parseInt(hours);

            if (!(minF <= f && f <= maxF && minH <= h && h <= maxH)) return "Invalid number";

            int remain = Testing.getTasksMax() - f;
            int result = 0;
            for (int i = 0; i < remain - 1; i++) {
                result += iterTime;
            }
            Log.d(TAG, "Result min: " + result + " Min: " + ((h - 1) * minInH));
            if (result <= ((h - 1) * minInH))
                return "Yes";
            else return "No";


        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Wrong number format";
        }


    }

    public void onclick(View v) {
        EditText etTasks = findViewById(R.id.etTasks);
        EditText etHours = findViewById(R.id.etHours);
        TextView tvResult = findViewById(R.id.tvResult);
        String result = perform(etTasks.getText().toString(), etHours.getText().toString());
        if(result != null){
            tvResult.setText(result);
        }
    }
}
