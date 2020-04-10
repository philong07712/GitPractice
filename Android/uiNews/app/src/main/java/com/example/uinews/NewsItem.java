package com.example.uinews;

public class NewsItem {
    int news_image;
    String news_title;
    String news_des;
    String news_date;

    public NewsItem(int news_image, String news_title, String news_des, String news_date) {
        this.news_image = news_image;
        this.news_title = news_title;
        this.news_des = news_des;
        this.news_date = news_date;
    }

    public NewsItem() {
    }

    public int getNews_image() {
        return news_image;
    }

    public void setNews_image(int news_image) {
        this.news_image = news_image;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_des() {
        return news_des;
    }

    public void setNews_des(String news_des) {
        this.news_des = news_des;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }
}
