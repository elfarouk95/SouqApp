package com.z.souqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView Tname;
    TextView TDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent n = getIntent();

        String name = n.getStringExtra("name");
        String details = n.getStringExtra("details");

        Tname = findViewById(R.id.TName);
        TDetails = findViewById(R.id.TDetails);


        Tname.setText(name);
        TDetails.setText(details);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
