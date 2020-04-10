package com.example.designpattern.StrategyPattern.Duck;

import com.example.designpattern.StrategyPattern.Behaviours.Fly.StrongFly;
import com.example.designpattern.StrategyPattern.Behaviours.Quack.StrongQuack;

public class WildDuck extends Duck {

    public WildDuck() {
        super(new StrongQuack(), new StrongFly());
    }
}
