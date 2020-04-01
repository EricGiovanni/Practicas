package com.example.practica1.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.practica1.R;

public class ListActivity extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        t = (TextView) findViewById(R.id.textView);
        t.setText(getIntent().getStringExtra("response"));
    }
}
