package com.example.workinfo.data;

import com.opencsv.bean.CsvBindByName;

public class FirstCompany {
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String size;
    @CsvBindByName
    private String name;

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }
}
