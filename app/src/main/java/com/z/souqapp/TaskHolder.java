package com.z.souqapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TaskHolder extends RecyclerView.ViewHolder {

    TextView TaskName;
    public TaskHolder(@NonNull View itemView) {
        super(itemView);
        TaskName =itemView.findViewById(R.id.TaskName);
    }
}
