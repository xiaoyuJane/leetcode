package DesignPattern.Factory.AbstractFatory.Impl;

import DesignPattern.Factory.AbstractFatory.Interface.WriteService;

public class ChineseWrite implements WriteService {

    @Override
    public void write(String name) {
        System.out.println("写：你好"+name);
    }
}
