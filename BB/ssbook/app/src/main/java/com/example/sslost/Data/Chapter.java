package com.example.sslost.Data;

public class Chapter {
    private int id;
    private String name;
    private int like;
    private String date;
    private int view;

    public Chapter(int id, String name, int like, String date, int view) {
        this.id = id;
        this.name = name;
        this.like = like;
        this.date = date;
        this.view = view;
    }

    public Chapter(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
