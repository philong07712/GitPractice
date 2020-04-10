package com.example.designpattern.StrategyPattern.Duck;

import com.example.designpattern.StrategyPattern.Behaviours.Fly.IFly;
import com.example.designpattern.StrategyPattern.Behaviours.Quack.IQuack;

public abstract class Duck {
    IQuack quack;
    IFly fly;
    public Duck(IQuack quack, IFly fly)
    {
        this.quack = quack;
        this.fly = fly;
    }
    public void quack()
    {
        this.quack.quack();
    }
    public void fly()
    {
        this.fly.fly();
    }
}
