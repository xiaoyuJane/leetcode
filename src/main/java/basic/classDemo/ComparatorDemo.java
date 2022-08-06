package basic.classDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Student1 stu1 = new Student1("sakuraamy",20);
        Student1 stu2 = new Student1("sakurabob",20);
        Student1 stu3 = new Student1("sakura",19);

        ArrayList<Student1> student1s = new ArrayList<>();
        student1s.add(stu1);
        student1s.add(stu2);
        student1s.add(stu3);

        //采用内部类的方式实现Comparator接口
        student1s.sort(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
//                return Integer.compare(o1.age,o2.age); //按年龄从小到大
//                return o1.name.compareTo(o2.name); //按名字从小到大
                if (o1.age == o2.age) return o1.name.compareTo(o2.name);
                else return Integer.compare(o1.age,o2.age);  //先按年龄，再按名字
            }
        });

        System.out.println(student1s);

    }

}

class Student1  {
     int age;
     String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student1() {
    }

    public Student1( String name,int age) {
        this.age = age;
        this.name = name;
    }





}
