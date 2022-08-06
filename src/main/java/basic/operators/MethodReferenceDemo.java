package basic.operators;

import basic.classDemo.App;
import jdk.jfr.StackTrace;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    public static void main(String[] args) {
//        test1();
//        test2();
        instanceTest();
    }


    //使用函数式接口的匿名类调用SimplePrinter.print方法
    public static void test1() {
        List<String> list = Arrays.asList("A", "B", "C");


        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String x) {
                SimplePrinter.print(x);
            }
        });
        /**
         * zz:A
         * zz:B
         * zz:C
         */

    }

    //使用lambda表达式来实现对每个元素调用 SimplePrinter.print操作
    public static void test2(){
        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(x -> SimplePrinter.print(x));
        /**
         * zz:A
         * zz:B
         * zz:C
         */
    }

    //使用函数引用来对每个元素调用 SimplePrinter.print操作
    public static void test3(){
        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(SimplePrinter::print);
        /**
         * zz:A
         * zz:B
         * zz:C
         */
    }

    public static void instanceTest(){
        List<Employee> list = Arrays.asList(
                new Employee("mkyong", 38, BigDecimal.valueOf(3800)),
                new Employee("zilap", 5, BigDecimal.valueOf(100)),
                new Employee("ali", 25, BigDecimal.valueOf(2500)),
                new Employee("unknown", 99, BigDecimal.valueOf(9999)));

        ComparatorProvider provider = new ComparatorProvider();


/*        //匿名内部类
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return provider.compareBySalary(o1,o2);
            }
        });*/

/*        //lambda
        list.sort((o1,o2)->provider.compareBySalary(o1,o2));*/

        //::
        list.sort(provider::compareBySalary);

        //打印结果
        list.forEach(System.out::println);


    }

    //引用构造函数
    @Test
    public void reference(){
        MethodReferenceDemo.toString(Employee::new); //Employee{name='null', age=null, salary=null}
    }
    public static void toString(Supplier supplier){
        System.out.println(supplier.get().toString());
    }

    @Test
    public void reference2(){
        Employee employee = new Employee();
        employee.setAge(10);
        employee.setName("zz");
        employee.setSalary(BigDecimal.valueOf(2500));
        Optional.of(employee).ifPresent(Employee::toString);

    }



}


//1.引用静态方法
class SimplePrinter {
    //类的静态方法
    public static void print(String str) {
        System.out.println("zz:"+str);

    }

}

//2.引用特定对象的实例方法
class ComparatorProvider {
    public int compareByAge(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

    public int compareByName(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareBySalary(Employee o1, Employee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}

class Employee{
    String name;
    Integer age;
    BigDecimal salary;

    public Employee(String name, Integer age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

