package com.example.uiintroslide;

public class ScreenItem {
    int intro_img;
    String intro_title;
    String intro_des;

    public ScreenItem(int intro_img, String intro_title, String intro_des) {
        this.intro_img = intro_img;
        this.intro_title = intro_title;
        this.intro_des = intro_des;
    }

    public ScreenItem() {
    }

    public int getIntro_img() {
        return intro_img;
    }

    public void setIntro_img(int intro_img) {
        this.intro_img = intro_img;
    }

    public String getIntro_title() {
        return intro_title;
    }

    public void setIntro_title(String intro_title) {
        this.intro_title = intro_title;
    }

    public String getIntro_des() {
        return intro_des;
    }

    public void setIntro_des(String intro_des) {
        this.intro_des = intro_des;
    }
}

