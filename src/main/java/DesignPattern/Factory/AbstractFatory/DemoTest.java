package DesignPattern.Factory.AbstractFatory;

import DesignPattern.Factory.AbstractFatory.Interface.AbstractFactory;

public class DemoTest {
    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getFactory("r");
        factory.sayHello("en").hello("xxx");
        factory.sayHello("zh").hello("xxx");
        factory.sayHello("yy").hello("xxx");

        AbstractFactory wfactory = FactoryProducer.getFactory("w");
        wfactory.writeHello("zh").write("xx");

    }


}
