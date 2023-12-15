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

        tableLayout = (TableLayout) findViewById(R.id.tablelayout);

        try {
            companyList = csvParser.getcompanyList(TopCompanyActivity.this);

            for (int i = 0; i < companyList.size(); i++) {
                TableRow tableRow = new TableRow(this);

                tableRow.setLayoutParams(new TableRow.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));

                TextView text= new TextView(this);
                text.setText(companyList.get(i).getSize());
                text.setTextSize(15);
                text.setGravity(Gravity.CENTER);

                TextView text2= new TextView(this);
                text2.setText(companyList.get(i).getName());
                text2.setTextSize(15);
                text2.setGravity(Gravity.CENTER);

                tableRow.addView(text);
                tableRow.addView(text2);

                tableLayout.addView(tableRow);
            }

        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
