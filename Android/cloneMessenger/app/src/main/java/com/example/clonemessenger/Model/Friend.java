package com.example.clonemessenger.Model;

import com.example.clonemessenger.R;

import java.util.ArrayList;
import java.util.List;

public class Friend implements IFriends {
    List<User> list = new ArrayList<>();

    public Friend() {
        initFriend();
    }

    public Friend(List<User> list) {
        this.list = list;
    }

    public User getUser(int position)
    {
        return list.get(position);
    }

    public List<User> getUserList()
    {
        return this.list;
    }

    public void initFriend()
    {
        for (int i = 0; i < 4; i++)
        {
            list.add(new User("Christ", "Chirst Evans", R.drawable.christ, true, 2));
            list.add(new User("Josh", "Josh brolin", R.drawable.josh, true, 1));
            list.add(new User("Mya", "Mya kaspersky", R.drawable.mya, false, 0));
            list.add(new User("Rose", "Roses imanbek", R.drawable.rose, true, 1));
            list.add(new User("Steve", "Steve martin", R.drawable.steve, true, 2));
            list.add(new User("Elena","Elena deligioz", R.drawable.elena, false, 0));
            list.add(new User("Han", "Han seung woo", R.drawable.han, true, 2));
            list.add(new User("Ethan", "Ethan cutkosky", R.drawable.ethan, false, 1));

        }
    }
}
