package DesignPattern.TemplateMode.TemplateMethod;

import DesignPattern.TemplateMode.TemplateMethod.AbstractMethod;

public class ImplMethod implements AbstractMethod {

    @Override
    public void say() {
        System.out.println("the summer is becoming");
    }
}
