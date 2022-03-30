package DesignPattern.TemplateMode.TemplateMethod;

import DesignPattern.TemplateMode.TemplateMethod.AbstractMethod;
import DesignPattern.TemplateMode.TemplateMethod.ImplMethod;

public class test {
    public static void main(String[] args) {
        AbstractMethod method = new ImplMethod();
        method.tell();

        /**
         * hello world!
         * the summer is becoming
         */
    }
}
