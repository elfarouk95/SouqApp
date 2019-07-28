package com.z.souqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TaskAdapter taskAdapter;
    Dbhelper dbhelper;
    ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.List);

        dbhelper = new Dbhelper(this);

        tasks = dbhelper.AllTasks();

        taskAdapter = new TaskAdapter(tasks);

        recyclerView.setAdapter(taskAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onResume() {
        super.onResume();
        tasks = dbhelper.AllTasks();

        Collections.sort(tasks);

        taskAdapter.setTasks(tasks);
        taskAdapter.notifyDataSetChanged();
    }

    public void OpenAddTask(View view) {
        Intent n = new Intent(this, AddTaskActivity.class);
        startActivity(n);
    }
}
