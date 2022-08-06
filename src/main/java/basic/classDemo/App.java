package basic.classDemo;


import java.util.Comparator;

public class App {
    public static void main(String[] args) {
//        testInnerClass();    //成员内部类的测试
//        testInnerClass1();   //局部内部类的测试
//        testInnerClass2();  //静态内部类的测试
//        testInnerClass3();  //匿名内部类的测试
//        testToString();    //toString 方法测试
//        testFinalize();     //finalize方法测试
        getClassTest();


    }
    public static void getClassTest(){
        ToStringDemo demo = new ToStringDemo(1, "z");
        Class<? extends ToStringDemo> aClass = demo.getClass();
        System.out.println(aClass);
    }

    //finalize方法测试
    public static void testFinalize(){
        FinalizeDemo test = new FinalizeDemo("test");
        test = null;
    }

    //toString 方法测试
    public static void testToString(){
        ToStringDemo demo = new ToStringDemo(1, "z");
        System.out.println(demo.toString());
    }

    //成员内部类的测试
    public static void testInnerClass(){
        OuterClass outerClass = new OuterClass();
        outerClass.display();
        /*this is outer class method
        null*/

        /*不能直接新建成员内部类
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();//报错
        成员内部类只能通过创建的类再去new*/
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        innerClass.display();
        /*this is inner class method
        Inner Class*/
    }

    //局部内部类的测试
    public static void testInnerClass1(){
        OuterClass1 outerClass1 = new OuterClass1();
        outerClass1.display(); //局部内部类的一个方法
    }

    //静态内部类的测试
    public static void testInnerClass2(){
        OuterClass2 outerClass2 = new OuterClass2();
        outerClass2.display();

        //静态内部类无需先构造外部类对象，可以直接new【区别于成员内部类】
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
        innerClass.display();
    }

    //匿名内部类的测试
    public static void testInnerClass3(){

        MyInterface myInterface = new MyInterface() {
            @Override
            public void test() {
                System.out.println("匿名内部类");
            }
        };

        myInterface.test();


    }

}
