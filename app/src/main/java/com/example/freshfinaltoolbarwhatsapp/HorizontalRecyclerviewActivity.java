package com.example.freshfinaltoolbarwhatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class HorizontalRecyclerviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HorizontalAdapter horizontalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recyclerview);
        recyclerView = findViewById(R.id.recyclerview);
        horizontalAdapter=new HorizontalAdapter(new String[]{"java","kotlin","C++","C#","PHP","Nodejs"});
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(horizontalAdapter);
    }
}
