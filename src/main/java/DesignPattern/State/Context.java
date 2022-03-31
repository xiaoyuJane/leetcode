package DesignPattern.State;

import DesignPattern.State.Abstract.State;
import DesignPattern.State.concrete.DefaultState;
import DesignPattern.State.concrete.OneState;
import DesignPattern.State.concrete.TwoState;

//拥有内部状态的类
public class Context {
    //提供了三种具体的内部状态，分别为default hello和hi
    public State defaultState = new DefaultState(this);
    public State helloState = new OneState(this);
    public State hiState = new TwoState(this);

    //提供一个cur状态，记录当前都状态
    public State curState = defaultState;

    //提供设置当前状态的方法
    public void setCurState(State state){
        this.curState = state;
    }

    public Context() {
    }

    public Context(State state){
        if (state !=null){
            curState = state;
        }
    }

    //对外提供say方法，通过curState变化控制状态
    public void say(){
        this.curState.say();
    }


}
