package com.z.souqapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
    ArrayList<Task> tasks = new ArrayList<>();

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item,viewGroup,false);
        TaskHolder taskHolder = new TaskHolder(v);
        return taskHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskHolder taskHolder, final int i) {

        taskHolder.TaskName.setText(tasks.get(i).getName());

        taskHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(taskHolder.itemView.getContext(),TaskDetailsActivity.class);
                n.putExtra("name",tasks.get(i).getName());
                n.putExtra("details",tasks.get(i).getDetails());
                taskHolder.itemView.getContext().startActivity(n);

            }
        });

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
