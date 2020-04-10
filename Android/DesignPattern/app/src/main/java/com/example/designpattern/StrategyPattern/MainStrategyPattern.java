package com.example.designpattern.StrategyPattern;

import com.example.designpattern.IPattern;
import com.example.designpattern.StrategyPattern.Duck.Duck;
import com.example.designpattern.StrategyPattern.Duck.MountainDuck;
import com.example.designpattern.StrategyPattern.Duck.WildDuck;

import java.util.ArrayList;
import java.util.List;

public class MainStrategyPattern implements IPattern {
    List<Duck> ducks;
    public MainStrategyPattern()
    {
        init();
    }

    public void run()
    {
        for (int i = 0; i < ducks.size(); i++)
        {
            ducks.get(i).quack();
            ducks.get(i).fly();
        }
    }

    public void init()
    {
        ducks = new ArrayList<>();
        addDuck();
    }

    public void addDuck()
    {
        ducks.add(new WildDuck());
        ducks.add(new MountainDuck());
    }

}
