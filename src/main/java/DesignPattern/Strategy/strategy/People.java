package DesignPattern.Strategy.strategy;

import DesignPattern.Strategy.strategy.Interface.Ball;
import DesignPattern.Strategy.strategy.Interface.Swim;

public class People {

    //技能不一定是每个人都会都，是会变的，将可变的能力抽象出来，使用接口
    //这里添加两个示例变量
    //父类People不自己处理打球和游泳，子类自己负责初始化这些接口对象
    Ball ball;
    Swim swim;

    //对外提供打球的能力
    public void playBall(){
        ball.play();
    }
    //对外提供游泳的能力
    public void swim(){
        swim.play();
    }

    //说话是每个人都会的，是不变的
    public void  speak(){
        System.out.println("i can speak");
    }

    //提供setter方法动态更新
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setSwim(Swim swim) {
        this.swim = swim;
    }
}
