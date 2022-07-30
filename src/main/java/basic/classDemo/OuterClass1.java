package basic.classDemo;

/**
 * 局部内部类： 在一个成员方法中定义的类，叫做局部内部类
 */
public class OuterClass1 {

    //成员变量
    private String OuterName;

    //成员方法
    public void display(){

        class InnerClass{

            public void print(){
                System.out.println("局部内部类的一个方法");
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }
}
