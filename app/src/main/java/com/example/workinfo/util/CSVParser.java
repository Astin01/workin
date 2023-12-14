package com.example.workinfo.util;

import android.content.Context;

import com.example.workinfo.R;
import com.example.workinfo.data.FirstCompany;
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
}