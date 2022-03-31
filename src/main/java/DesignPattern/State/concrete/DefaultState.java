package DesignPattern.State.concrete;

import DesignPattern.State.Context;
import DesignPattern.State.Abstract.State;

public class DefaultState extends State {

    public DefaultState(Context context) {
        super(context);
    }

    //处理具体状态的行为
    @Override
   public void say() {
        System.out.println("i am the default state");
        context.setCurState(context.helloState);
    }
}
