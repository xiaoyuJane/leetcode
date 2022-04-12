package DesignPattern.Factory.AbstractFatory.Impl;

import DesignPattern.Factory.AbstractFatory.Interface.AbstractFactory;
import DesignPattern.Factory.AbstractFatory.Interface.WriteService;
import DesignPattern.Factory.FactoryMethod.Impl.ChineseHello;
import DesignPattern.Factory.FactoryMethod.Impl.EnglishHello;
import DesignPattern.Factory.FactoryMethod.Impl.YueYuHello;
import DesignPattern.Factory.FactoryMethod.Interface.SimpleService;

public class HelloFactory extends AbstractFactory {

    @Override
    public SimpleService sayHello(String city) {
       if ("en".equals(city)) return new EnglishHello();
       else if ("zh".equals(city)) return new ChineseHello();
       else if ("yy".equals(city)) return new YueYuHello();
       return null;
    }

    @Override
    public WriteService writeHello(String city) {
        return null;
    }
}
