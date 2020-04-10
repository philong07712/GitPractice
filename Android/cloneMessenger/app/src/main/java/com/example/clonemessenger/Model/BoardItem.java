package com.example.clonemessenger.Model;

public class BoardItem extends User {
    int userImage;

    public BoardItem(String name, String fullName, int img, boolean isOnline, int read, int userImage) {
        super(name, fullName, img, isOnline, read);
        this.userImage = userImage;
    }

    public BoardItem(User user, int userImage)
    {
        super(user.getName(), user.getFullName(), user.getImg(), user.isOnline(), user.getRead());
        this.userImage = userImage;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
