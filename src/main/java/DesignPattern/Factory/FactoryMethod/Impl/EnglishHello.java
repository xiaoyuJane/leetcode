package DesignPattern.Factory.FactoryMethod.Impl;

import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public class EnglishHello implements SimpleService {

    //构造方法没有任何返回值，默认返回类型就是对象类型本身
    //可以有访问权限控制符，如public 或者protected
    public EnglishHello(){

    }

    @Override
    public void hello(String name) {
        System.out.println("hello,"+name);
    }
}
