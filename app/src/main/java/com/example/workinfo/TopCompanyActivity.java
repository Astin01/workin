package com.example.workinfo;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workinfo.data.FirstCompany;
import com.example.workinfo.util.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TopCompanyActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private List<FirstCompany> companyList = new ArrayList<FirstCompany>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topcompany);
        CSVParser csvParser = new CSVParser();
        try {
            companyList = csvParser.getcompanyList(TopCompanyActivity.this);
            companyList.size();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_topcompany);
//        CSVParser csvParser = new CSVParser();
//

//        tableLayout = (TableLayout) findViewById(R.id.tablelayout);
//        TableRow tableRow = new TableRow(this);
//        tableRow.setLayoutParams(new TableRow.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        ));
//
//        try {
//            List<FirstCompany> firstCompanyList = csvParser.getcompanyList(TopCompanyActivity.this);
//            for (int i = 0; i < firstCompanyList.size(); i++) {
//                TextView textView = new TextView(this);
//                textView.setText(String.valueOf(i));
//                textView.setGravity(Gravity.CENTER);
//                textView.setTextSize(36);
//                tableRow.addView(textView);
//            }
//            tableLayout.addView(tableRow);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
