package DesignPattern.State.Abstract;


import DesignPattern.State.Context;

//抽象状态类
//定义状态的抽象接口，这样所有状态都需要实现这个接口，这样状态之间就能相互切换
public abstract class State {
    public Context context;

    //保存了一个上下文对象
    public State(Context context){
        this.context = context;
    }

    //抽象方法say，要求所有具体状态类都需要实现
    public abstract void say();
}
