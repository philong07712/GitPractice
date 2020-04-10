package com.example.clonemessenger.Model;

import com.example.clonemessenger.R;

import java.util.List;

public interface IFriends {
    public User getUser(int position);
    public void initFriend();
    public List<User> getUserList();
}
