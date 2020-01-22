package com.admins.myrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter recyclerAdapter;
    private ArrayList<String> displayedList,questionList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.recycler);

        questionList = new ArrayList<>();
        displayedList = new ArrayList<>();

        questionList.add("Apple");
        questionList.add("Banana");
        questionList.add("Pineapple");
        questionList.add("Orange");
        questionList.add("Lychee");
        questionList.add("Gavava");
        questionList.add("Peech");
        questionList.add("Melon");
        questionList.add("Watermelon");
        questionList.add("Papaya");
        setupRecyclerView();
    }
    // init Recycler View
    private void setupRecyclerView() {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(MainActivity.this,
                questionList,displayedList);
        rv.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

    }
}
