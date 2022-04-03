package DesignPattern.Factory.FactoryMethod.Impl;

import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public class YueYuHello implements SimpleService {

    @Override
    public void hello(String name) {
        System.out.println("粤语：你好，"+name);
    }
}
