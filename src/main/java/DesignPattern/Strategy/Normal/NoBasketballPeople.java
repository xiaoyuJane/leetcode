package DesignPattern.Strategy.Normal;

//不会打篮球的人，通过重写某个技能方法覆盖父类的方法
public class NoBasketballPeople extends People{
    @Override
    public void playBasketball() {
//        super.playBasketball(); //使其丧失了打篮球的技能
    }
}
