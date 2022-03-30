package DesignPattern.Strategy.strategy;

import DesignPattern.Strategy.strategy.impl.Breaththroke;
import DesignPattern.Strategy.strategy.impl.FootballAble;

public class Test {
    public static void main(String[] args) {
        People people = new BasketBallAndDogRunSwimPeople();
        people.speak();
        people.swim();
        people.playBall();

        System.out.println("-------------");
        people.setBall(new FootballAble());
        people.setSwim(new Breaththroke());
        people.speak();
        people.swim();
        people.playBall();
    }
}
