package basic.Generics;

public class StaticDemo {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }

}

class A{

    //执行时机1
    //静态代码的执行是从上到下的
    static {
        System.out.println("A类静态代码块初始化");
        m=300;
    }

    //执行时机2
    static int m = 100;


    //执行时机3
    public A(){
        System.out.println("A类无参构造初始化");
        m = 200;
    }
}