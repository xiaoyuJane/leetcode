package DesignPattern.Strategy.Normal;
//父类，超类，定义了人的一些技能
//问题：随着人越来越多，难避免会产生一些技能，需要修改父类，增加方法；并且对于不会该技能的具体人，还需要同步修改子类去覆盖技能方法
//违反了开闭原则，使得代码较难维护，且重复率高
public class People {
    public void speak(){
        System.out.println("i can speak");
    }

    public void playBasketball(){
        System.out.println("i can play basketball");
    }

    public void playFootball(){
        System.out.println("i can play football");
    }

    public void playTableTennis(){
        System.out.println("i can play tennis ball");
    }

    public  void swim(){
        System.out.println("i can swim");
    }
}
