package com.example.designpattern.StrategyPattern.Behaviours.Fly;

import android.util.Log;

public class StrongFly implements IFly {

    @Override
    public void fly() {
        Log.d("StrategyPattern", "Strong fly called");
    }
}
