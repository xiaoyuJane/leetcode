package DesignPattern.Strategy.strategy;

import DesignPattern.Strategy.strategy.impl.BasketballAble;
import DesignPattern.Strategy.strategy.impl.DogRunSwim;

public class BasketBallAndDogRunSwimPeople extends People{
    public BasketBallAndDogRunSwimPeople(){
        //在子类中去定义父类中的接口的实现
        super.ball = new BasketballAble();
        super.swim = new DogRunSwim();

    }
}
