package DesignPattern.Factory.SimpleFactory.Impl;

import DesignPattern.Factory.SimpleFactory.Interface.SimpleService;

public class ChineseHello implements SimpleService {

    public ChineseHello() {
    }

    @Override
    public void hello(String name) {
        System.out.println("你好，" + name);
    }
}
