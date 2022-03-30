package DesignPattern.TemplateMode.TemplateMethod;

//模板模式

/**
 * 定义一个操作中的算法骨架，它将算法的一些步骤延迟到子类中实现
 * 使得子类可以不改变算法接口的情况下重新定义算法的某些步骤
 * 模板模式是一种行为型模式
 */

//定义一个抽象类，模板方法
//默认方法要求输出一个hello world + 别的语句
//别的语句由子类来实现输出
public interface AbstractMethod {
    //需要子类中去重写的方法
    void say();

    default void tell(){
        System.out.println("hello world!");
        this.say();
    }
}
