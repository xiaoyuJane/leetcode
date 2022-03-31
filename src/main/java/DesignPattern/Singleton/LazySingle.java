package DesignPattern.Singleton;

import java.util.Objects;

public final class LazySingle {
    private LazySingle(){}

    private  static  LazySingle lazySingle;

    //懒汉模式即在调用getInstance时创建对象（加载）
    //如下代码单线程下没有问题，多个线程下就会存在多个实例来
/*    public static LazySingle getInstance(){
        if (Objects.isNull(lazySingle)){  //在线程1创建实例的漫长过程中，值还为null，线程2进入类if判断，此时判断为true，也能进入
            lazySingle = new LazySingle();  //线程1正在创建lazySingle，由于jvm创建类实例时比较慢，值可能为null
        }
        return lazySingle;
    }*/


    //多线程情况下，在方法上加sychronized 同步锁，保证同时只有一个线程可以进入方法
    //同步锁会耗性能，不适用于高性能程序
    public static synchronized LazySingle getInstance(){
        if (Objects.isNull(lazySingle)){  //在线程1创建实例的漫长过程中，值还为null，线程2进入类if判断，此时判断为true，也能进入
            lazySingle = new LazySingle();  //线程1正在创建lazySingle，由于jvm创建类实例时比较慢，值可能为null
        }
        return lazySingle;
    }

}
