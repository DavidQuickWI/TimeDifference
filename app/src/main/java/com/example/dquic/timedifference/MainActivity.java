package com.example.dquic.timedifference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected EditText in_time1;
    protected EditText in_time2;
    protected Button in_btn;
    protected TextView out_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_btn = (Button)findViewById(R.id.button);
        in_btn.setOnClickListener(this);
        in_time1 = (EditText) findViewById(R.id.time1);
        in_time2 = (EditText)findViewById(R.id.time2);
        out_results = (TextView)findViewById(R.id.output);
    }

    @Override
    public void onClick(View view){
        int[] time1 = new int[2];
        int[] time2 = new int[2];

        // Get the first time
        String timeInput = in_time1.getText().toString();
        String[] time = timeInput.split(":");
        // Convert to integers
        time1[0] = Integer.parseInt(time[0]);
        time1[1] = Integer.parseInt(time[1]);

        // Get the second time
        timeInput = in_time2.getText().toString();
        time = timeInput.split(":");
        // Convert to integers
        time2[0] = Integer.parseInt(time[0]);
        time2[1] = Integer.parseInt(time[1]);

        int[] calculatedTime = new int[2];

        // Calculate the time difference
        if(time1[0] > time2[0]){
            calculatedTime[0] = time1[0] - time2[0];
            calculatedTime[1] = time1[1] - time2[1];
        } else {
            calculatedTime[0] = time2[0] - time1[0];
            calculatedTime[1] = time2[1] - time1[1];
        }

        // Make minutes presentable
        if(calculatedTime[1] < 0)
            calculatedTime[1] += 60;
        String minutes = "" + calculatedTime[1];
        if(calculatedTime[1] < 10)
            minutes = "0" + calculatedTime[1];

        // Output difference
        out_results.setText(calculatedTime[0] + ":" + minutes);
    }
}
