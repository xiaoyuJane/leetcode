package DesignPattern.Factory.AbstractFatory.Impl;

import DesignPattern.Factory.AbstractFatory.Interface.AbstractFactory;
import DesignPattern.Factory.AbstractFatory.Interface.WriteService;
import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public class WriteFactoy extends AbstractFactory {

    @Override
    public SimpleService sayHello(String city) {
        return null;
    }

    @Override
    public WriteService writeHello(String city) {
        return new ChineseWrite();
    }
}
