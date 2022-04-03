package DesignPattern.Factory.FactoryMethod.Impl;

import DesignPattern.Factory.FactoryMethod.AbstractHelloFactory;
import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public class ForeignCreateFactory extends AbstractHelloFactory {

    @Override
    public SimpleService[] create() {
        return new SimpleService[]{new EnglishHello()};
    }
}
