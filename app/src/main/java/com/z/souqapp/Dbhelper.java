package com.z.souqapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(Context c) {
        super(c, "task.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table Tasks (\n" +
                "id INTEGER,\n" +
                "name Text ,\n" +
                "details Text,\n" +
                "proi INTEGER\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT into Tasks (name,details,proi) VALUES ('" + task.getName() + "','" + task.getDetails() + "'," + task.getPro() + "); ");

    }

    public void UpTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("" +
                "UPDATE Tasks SET " +
                "name ='" + task.getName() + "'," +
                "details='" + task.getDetails() + "'," +
                "proi =" + task.getPro() + " " +
                "WHERE id =" + task.getId());
    }

    public ArrayList<Task> AllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Task> tasks = new ArrayList<>();
        Cursor c = db.rawQuery("Select * From Tasks", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            String details = c.getString(2);
            int p = c.getInt(3);

            Task task = new Task(id, name, details, p);
            tasks.add(task);
            c.moveToNext();
        }
        return tasks;

    }

}
