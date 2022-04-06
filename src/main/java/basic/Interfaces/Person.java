package basic.Interfaces;


//接口可以包含变量、方法
public interface Person {

    //1.变量被隐式指定为public static final
    public static final int a=10;

    //2.方法被隐式指定为public abstract（JDK1.8之前）
    //抽象方法必须被子类实现
    public void eat();

    //3.默认方法（JDK1.8）--允许给接口添加非抽象的方法
    //可以不被实现子类所实现，只能被实现子类的对象调用
    //如果子类实现了多个接口，并且这些接口包含一样的默认方法，则子类必须重写默认方法
    default void  sleep(){
        System.out.println("Person sleep~~");
    }

    default void  work(){
        System.out.println("Person work~~");
    }

    //静态方法，通过Person.test()访问
    static void test(){
        System.out.println("Person static method test~");
    }

}


class Student implements Person{
    //重写抽象方法
    @Override
    public void eat() {
        System.out.println("Student eat school food ");
    }

    //可重写default方法
    @Override
    public void work() {
        System.out.println("Student study~~");
    }
}



