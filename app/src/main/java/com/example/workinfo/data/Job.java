package com.example.workinfo.data;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class Job {
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String total;
    @CsvBindByName
    private String people;
    @CsvBindByName
    private String sucess;


    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void setSucess(String sucess) {
        this.sucess = sucess;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }

    public String getSucess() {
        return sucess;
    }

    public String getPeople() {
        return people;
    }
}
