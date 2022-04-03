package DesignPattern.Factory.FactoryMethod.Impl;


import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public class ChineseHello implements SimpleService {

    public ChineseHello() {
    }

    @Override
    public void hello(String name) {
        System.out.println("你好，" + name);
    }
}
