package com.z.souqapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddTaskActivity extends AppCompatActivity {

    EditText name;
    EditText details;
    RadioGroup radioGroup;
    int p = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        name = findViewById(R.id.name);
        details = findViewById(R.id.details);

        radioGroup = findViewById(R.id.Pro);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.L:
                        p = 1;
                        break;
                    case R.id.M:
                        p = 2;
                        break;
                    case R.id.H:
                        p = 3;
                        break;
                }
            }
        });
    }

    public void AddTask(View view) {

        Task task = new Task(name.getText().toString(), details.getText().toString(), p);

        Dbhelper d = new Dbhelper(this);

        d.InsertTask(task);

        finish();
    }
}
