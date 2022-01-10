package com.example.sslost.Data;

public class ChapterDetail {
    private int id;
    private String imagePath;
    private int chapterId;

    public ChapterDetail(int id, int chapterId, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
        this.chapterId = chapterId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
