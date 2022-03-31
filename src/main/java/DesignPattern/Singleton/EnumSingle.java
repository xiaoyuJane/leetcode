package DesignPattern.Singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum  EnumSingle {

    INSTANCE;

    private final Demo demo;

    EnumSingle(){
        demo = new Demo();
    }

    public Demo get(){
        return demo;
    }

}

class Demo{
    private  static AtomicLong id = new AtomicLong(0);
    public long getId(){
        return  id.incrementAndGet();
    }

}
