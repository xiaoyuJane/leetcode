package DesignPattern.State.concrete;

import DesignPattern.State.Context;
import DesignPattern.State.Abstract.State;

public class OneState extends State {

    public OneState(Context context) {
        super(context);
    }

    @Override
    public void say() {
        System.out.println("i am the hello state");
        context.setCurState(context.hiState);
    }
}
