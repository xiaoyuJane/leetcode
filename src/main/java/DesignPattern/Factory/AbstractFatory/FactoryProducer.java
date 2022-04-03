package DesignPattern.Factory.AbstractFatory;

import DesignPattern.Factory.AbstractFatory.Impl.HelloFactory;
import DesignPattern.Factory.AbstractFatory.Impl.WriteFactoy;
import DesignPattern.Factory.AbstractFatory.Interface.AbstractFactory;

//final修饰的类不可被继承
public final class FactoryProducer {
    private FactoryProducer(){}

    public static AbstractFactory getFactory(String doType){
        if ("r".equals(doType)) return new HelloFactory();
        else if ("w".equals(doType)) return new WriteFactoy();

        return null;
    }

}
