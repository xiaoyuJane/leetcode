package basic.classDemo;

/**
 * 成员内部类（非静态内部类）
 * 要创建它，必须先存在一个外部类对象才能新建
 */
public class OuterClass {

    //成员变量
   private String OuterName;

   //成员方法
   public void display(){
       System.out.println("this is outer class method");
       System.out.println(OuterName);
   }


   public class InnerClass{
       private String InnerName;

       public InnerClass(){
           InnerName = "Inner Class";
       }

       public void display(){
           System.out.println("this is inner class method");
           System.out.println(InnerName);
       }
   }
}
