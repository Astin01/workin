package com.example.workinfo;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workinfo.data.FirstCompany;
import com.example.workinfo.data.Job;
import com.example.workinfo.util.CSVParser;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobActivity  extends AppCompatActivity {

    private List<Job> jobList = new ArrayList<Job>();
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        CSVParser csvParser = new CSVParser();

        try {
            jobList = csvParser.getJobList(JobActivity.this);
            BarChart barChart = (BarChart) findViewById(R.id.bar);
            csvParser.setChart(jobList,barChart);

        }
        catch (IOException e){

        }
    }

}
