package com.example.uicardlist;

public class item {
    int cover;
    int nb_follower;
    int profile;
    String name;

    public item(int cover, int nb_follower, int profile, String name) {
        this.cover = cover;
        this.nb_follower = nb_follower;
        this.profile = profile;
        this.name = name;
    }

    public item() {
    }

    public int getCover() {
        return cover;
    }

    public int getNb_follower() {
        return nb_follower;
    }

    public int getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public void setNb_follower(int nb_follower) {
        this.nb_follower = nb_follower;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public void setName(String name) {
        this.name = name;
    }
}
