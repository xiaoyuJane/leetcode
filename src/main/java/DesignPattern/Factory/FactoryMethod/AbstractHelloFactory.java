package DesignPattern.Factory.FactoryMethod;

import DesignPattern.Factory.FactoryMethod.Impl.ChineseCreateFactory;
import DesignPattern.Factory.FactoryMethod.Impl.ForeignCreateFactory;
import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

import java.util.Arrays;

//工厂类为抽象类
//由中国和外国工厂继承抽象类
public abstract class AbstractHelloFactory {
    //构造器
    protected AbstractHelloFactory(){}

    //抽象方法，返回值为SimpleService[]，接口可以看成一种类型
    public abstract SimpleService[] create();

    //对外暴露的静态方法
    public static void print(SimpleService[] arr){
        Arrays.stream(arr).forEach(simpleService -> simpleService.hello("xxx"));
    }

    //test
    public static void main(String[] args) {
        AbstractHelloFactory.print(new ChineseCreateFactory().create());
        AbstractHelloFactory.print(new ForeignCreateFactory().create());
    }


}
