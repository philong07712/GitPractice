package com.example.clonemessenger.Model;

import com.example.clonemessenger.R;

public class User implements IUser {
    String name;
    String fullName;
    int img;
    boolean isOnline;
    int read, read_img;
    public final int GONE = 0, READ = 1, UNREAD = 2;

    public User() {
    }

    public User(String name, String fullName, int img, boolean isOnline, int read) {
        this.name = name;
        this.fullName = fullName;
        this.img = img;
        this.isOnline = isOnline;
        this.read = read;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getRead()
    {
        return this.read;
    }

    public void setRead(int isRead)
    {
        this.read = isRead;
    }

    public int getReadImg()
    {
        switch (this.read)
        {
            case 1:
                return R.drawable.news_true;
            case 2:
                return R.drawable.news_false;
            default:
                return android.R.color.transparent;
        }
    }
    public String getFullName()
    {
        return this.fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
}
