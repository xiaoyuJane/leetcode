package DesignPattern.Factory.AbstractFatory.Interface;

import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public abstract class AbstractFactory {
   public abstract SimpleService sayHello(String city);
   public abstract WriteService writeHello(String city);
}
