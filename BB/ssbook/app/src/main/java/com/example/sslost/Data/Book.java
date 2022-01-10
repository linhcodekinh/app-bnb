package com.example.sslost.Data;

public class Book {
    private int id;
    private String name;
    private String thumbnail;
    private String description;
    private String author;
    private int totalView, totalChapter, totalLike;
    private String updateDate;


    public Book(int id, String name, String thumbnail) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public Book(String name, String thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public Book(int id, String name, String thumbnail, String description, int totalView, int totalLike) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.description = description;
        this.totalView = totalView;
        this.totalLike = totalLike;
    }

    public Book(int id, String name,  String author, String thumbnail, String date) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.author = author;
        this.updateDate = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getTotalChapter() {
        return totalChapter;
    }

    public void setTotalChapter(int totalChapter) {
        this.totalChapter = totalChapter;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalView() {
        return totalView;
    }

    public void setTotalView(int totalView) {
        this.totalView = totalView;
    }

    public int getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }
}