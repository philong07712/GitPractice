package com.example.mvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser {
    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isValidData() {
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 6;
    }
}
