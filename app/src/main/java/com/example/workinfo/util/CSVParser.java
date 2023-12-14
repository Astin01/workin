package com.example.workinfo.util;

import android.content.Context;

import com.example.workinfo.R;
import com.example.workinfo.data.FirstCompany;
import com.example.workinfo.data.Job;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public CSVParser() {
        // 빈 생성자
    }

    public List<FirstCompany> getcompanyList(Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(R.raw.firstcompany);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String line = "";

        List<FirstCompany> companyList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");    // 각 행을 순차적으로 돌면서 , 를 기준으로 분리하여 배열에 저장한다.

            FirstCompany firstCompany = new FirstCompany();
            firstCompany.setSize(tokens[1]);
            firstCompany.setName(tokens[2]);

            companyList.add(firstCompany);
        }

        reader.close();
        is.close();

        return companyList;
    }

    public List<Job> getJobList(Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(R.raw.job);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String line = "";

        List<Job> jobList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");    // 각 행을 순차적으로 돌면서 , 를 기준으로 분리하여 배열에 저장한다.

            Job job = new Job();
            job.setDate(tokens[0]);
            job.setTotal(tokens[1]);
            job.setPeople(tokens[2]);
            job.setSucess(tokens[3]);

            jobList.add(job);
        }

        reader.close();
        is.close();

        return jobList;
    }
    public void setChart(List<Job> jobList, BarChart barChart){
        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();
        List<BarEntry> entriesGroup3 = new ArrayList<>();

        for(int i = 1; i < jobList.size(); i++) {
            entriesGroup1.add(new BarEntry(i, Integer.parseInt(jobList.get(i).getTotal())));
            entriesGroup2.add(new BarEntry(i, Integer.parseInt(jobList.get(i).getPeople())));
            entriesGroup3.add(new BarEntry(i, Integer.parseInt(jobList.get(i).getSucess())));
        }
        BarDataSet set1 = new BarDataSet(entriesGroup1, "구직인원");
        BarDataSet set2 = new BarDataSet(entriesGroup2, "구직자수");
        BarDataSet set3 = new BarDataSet(entriesGroup3, "취업건수");

        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
// (0.02 + 0.45) * 2 + 0.06 = 1.00 -> interval per "group"
        BarData data = new BarData(set1, set2,set3);
        data.setBarWidth(barWidth); // set the width of each bar
        barChart.setData(data);
        barChart.groupBars(0, groupSpace, barSpace); // perform the "explicit" grouping
        barChart.invalidate(); // refresh
    }
}