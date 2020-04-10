package com.example.designpattern.StrategyPattern.Behaviours.Quack;

import android.util.Log;

public class StrongQuack implements IQuack{

    @Override
    public void quack() {
        Log.d("StrategyPattern", "Strong Quack called");
    }
}
