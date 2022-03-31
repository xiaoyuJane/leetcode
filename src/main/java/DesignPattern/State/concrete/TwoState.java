package DesignPattern.State.concrete;

import DesignPattern.State.Context;
import DesignPattern.State.Abstract.State;

public class TwoState extends State {

    public TwoState(Context context) {
        super(context);
    }

    @Override
   public void say() {
        System.out.println("i am the hi state");
        context.setCurState(context.defaultState);

    }
}
