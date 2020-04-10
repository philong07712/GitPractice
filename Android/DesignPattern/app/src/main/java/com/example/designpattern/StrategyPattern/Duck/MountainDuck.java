package com.example.designpattern.StrategyPattern.Duck;

import com.example.designpattern.StrategyPattern.Behaviours.Fly.IFly;
import com.example.designpattern.StrategyPattern.Behaviours.Fly.NoFly;
import com.example.designpattern.StrategyPattern.Behaviours.Quack.IQuack;
import com.example.designpattern.StrategyPattern.Behaviours.Quack.StrongQuack;

public class MountainDuck extends Duck {

    public MountainDuck() {
        super(new StrongQuack(), new NoFly());
    }
}
