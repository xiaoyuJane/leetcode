package DesignPattern.Singleton;

//一个类要么面向继承，要么被final修饰
//单例模式无法被继承，所以使用final来修饰
public final class HungrySingle {

    //类实例应该由类自己创建，所以此处私有化构造器
    private HungrySingle(){}

    //使用静态成员变量创建类实例
    //此处生命为final，意为对象引用不可变
    //被static和final修饰的为常量
    private final static HungrySingle HUNGRY_SINGLE = new HungrySingle();

    //提供全局访问点
    //访问对象实例，通常方法命名为getInstance
    public  static  HungrySingle getInstance(){
        return HUNGRY_SINGLE;
    }

}
