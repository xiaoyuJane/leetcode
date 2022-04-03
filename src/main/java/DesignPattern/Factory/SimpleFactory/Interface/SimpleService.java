package DesignPattern.Factory.SimpleFactory.Interface;

/**
 *
 *
 * 接口知识：
 * - 接口是一种抽象类型
 * - 接口是抽象方法的集合和全局常量组成（public static final）
 * - 实现接口的类如果没有实现接口中所有的方法，那么该类就需要被声明为抽象类
 */
public interface SimpleService {

    //接口中所有方法必须只声明方法标识，而不要声明具体的方法体（接口不管实现，所以不需要{}内容）
    //省略了public and abstract
    void hello(String name);
}
