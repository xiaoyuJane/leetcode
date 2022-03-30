package DesignPattern.Strategy.strategy.impl;

import DesignPattern.Strategy.strategy.Interface.Ball;

//球类技能实现Ball接口
public class FootballAble implements Ball {

    @Override
    public void play() {
        System.out.println("i can play football");
    }
}
