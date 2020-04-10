package com.example.uicardbook;

public class Book {
    private String title;
    private String description;
    private String category;
    private int cover;

    public Book() {
    }

    public Book(String title, String description, String category, int cover) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
