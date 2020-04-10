package com.example.designpattern.StrategyPattern.Behaviours.Fly;

import android.util.Log;

public class NoFly implements IFly {

    @Override
    public void fly() {
        Log.d("StrategyPattern", "No Fly called");
    }
}
