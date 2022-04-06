package basic.Interfaces;

public class Test {
    public static void main(String[] args) {
        Person student = new Student();
        student.eat(); //Student eat school food
        student.sleep(); //Person sleep~~
        student.work(); //Student study~~

        //静态方法的调用
        Person.test();  //Person static method test~
    }
}
