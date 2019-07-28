package com.z.souqapp;

public class Task implements Comparable<Task> {


    @Override
    public int compareTo(Task o) {
        if (pro > o.getPro()) return 1;
        else if (pro<o.getPro())return -1;
        else return 0;

    }


    private int id;
    private String name;
    private String details;
    private int pro;

    public Task(String name, String details, int pro) {
        this.name = name;
        this.details = details;
        this.pro = pro;
    }

    public Task(int id, String name, String details, int pro) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.pro = pro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }


}


