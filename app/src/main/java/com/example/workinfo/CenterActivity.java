package com.example.workinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CenterActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        Button sendButton = (Button) findViewById(R.id.send);
        EditText text = (EditText) findViewById(R.id.title);
        EditText text2 = (EditText) findViewById(R.id.content);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                String[] address = {"email@address.com"};
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT, text.getText());
                email.putExtra(Intent.EXTRA_TEXT, text2.getText());
                startActivity(email);
            }
        });
    }
}
