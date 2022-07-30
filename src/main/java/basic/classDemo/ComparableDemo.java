package basic.classDemo;

import java.util.TreeSet;

public class ComparableDemo {
    public static void main(String[] args) {
        Student stu1 = new Student("aa",20);
        Student stu2 = new Student("bb",21);
        Student stu3 = new Student("cc",19);

        //TreeSet会对插入的对象进行自动排序，所以要求对象必须实现了Comparable接口
        TreeSet<Student> stuSet = new TreeSet<>();
        stuSet.add(stu1);
        stuSet.add(stu2);
        stuSet.add(stu3);
        //使用foreach(), lambda表达式输出stuSet中的值 forEach()方法从JDK1.8才开始有
        stuSet.forEach(stu->System.out.println(stu));
    }
}

class Student implements Comparable<Student>{
    private int age;
    private String name;

    //重写comparaTo方法 以age作为标准比较大小
    @Override
    public int compareTo(Student o) { //本类接收本类对象，对象可以直接访问属性(取消了第一个对象的传入)
//        return (this.age<o.age ? -1 : (this.age == o.age ? 0 : 1));
//        return (-Integer.compare(this.age, o.age)); //默认从小到大，取反则为从大到小
        return (-this.name.compareTo(o.name)); //默认从小到大，取反则为从大到小
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student() {
    }

    public Student( String name,int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
