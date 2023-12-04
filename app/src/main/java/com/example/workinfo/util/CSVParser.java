package com.example.workinfo.util;

import android.content.Context;
import com.example.workinfo.data.FirstCompany;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVParser {

    public CSVParser() {
        // 빈 생성자
    }

    public List<FirstCompany> getcompanyList(Context context) throws IOException {
        List<FirstCompany> firstCompanyList = new CsvToBeanBuilder<FirstCompany>(new FileReader("firstCompany.csv"))
                .withType(FirstCompany.class)
                .build()
                .parse();
        firstCompanyList.forEach(member -> System.out.println(member.getName() + ", " + member.getSize()));

        return firstCompanyList;
    }
}