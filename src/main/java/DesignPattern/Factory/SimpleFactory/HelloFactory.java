package DesignPattern.Factory.SimpleFactory;

import DesignPattern.Factory.SimpleFactory.Impl.ChineseHello;
import DesignPattern.Factory.SimpleFactory.Impl.EnglishHello;
import DesignPattern.Factory.SimpleFactory.Interface.SimpleService;

/**
 * 简单工厂模式
 * - 将实例化的代码从应用代码中抽离，只需要传入参数即可
 * - 在final修饰的工厂中实现类的创建
 */

//被final 修饰的类不能被继承
public final class HelloFactory {

    //私有构造器
    private HelloFactory(){
        throw new IllegalStateException("private HelloFactory");
    }

    //static 修饰方法，表示方法属于类，可以直接调用静态方法而无需创建类的实例，它可以访问类的静态数据成员并更改静态数据成员的值
    public static SimpleService creat(String city){
        if ("en".equals(city)) return new EnglishHello();
        else if ("ch".equals(city)) return new ChineseHello();
        throw new IllegalArgumentException("city");
    }

    //test
    public static void main(String[] args) {
        HelloFactory.creat("en").hello("xx");
        HelloFactory.creat("ch").hello("xx");
    }
}
