package com.example.practica1.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.practica1.R;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list);
        StringTokenizer s = new StringTokenizer(getIntent().getStringExtra("response"), " ");
        while(s.hasMoreTokens()){
            list.add(s.nextToken());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);+
    }
}
