package basic.objectDemo;

public class Demo01 {
    public static void main(String[] args) {
        A a = new A();
        A a1 = a; //a1 指向a
        A a2 = a1; //a2 指向a

        System.out.println(a == a2); //true
        System.out.println(a1 == a2); //true

        B obj = a; //父类类型指向子类对象，仍然指向的是a，地址不变
        System.out.println(obj == a2); //true
    }
}

class B{}
class A extends B{}
