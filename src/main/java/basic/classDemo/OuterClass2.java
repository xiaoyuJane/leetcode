package basic.classDemo;

public class OuterClass2 {

    //成员变量
    private String OuterName;
    //成员方法
    public void display(){
        System.out.println("this is outer class method");
        System.out.println(OuterName);
    }
    //静态内部类
    public static class InnerClass{
        private String InnerName;

        public InnerClass(){
            InnerName = "inner";
        }

        public void display(){
            System.out.println("this is static inner class method");
            System.out.println(InnerName);
        }
    }
}
