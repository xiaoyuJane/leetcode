package DesignPattern.Strategy.strategy.impl;

import DesignPattern.Strategy.strategy.Interface.Swim;

//球类技能实现Ball接口
public class Breaththroke implements Swim {

    @Override
    public void play() {
        System.out.println("i can breaththroke");
    }
}
