package basic.streamDemo;

import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class reduceDemo {

    @Test
    public void test1(){
        // Stream 归约操作
        List<Integer> list = Arrays.asList(1,2,3,4);

        // reduce()方法中第一个参数是起始值,
        // 第二个参数Lambda表达式中第一个参数x就是起始值,lambda表达式第二个参数y就是集合中的每个值
        // 遍历集合中每个参数作为y,然后进行计算(x+y) 得到结果作为x,最后将所有结果相加,得到sum
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum); //10

        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println(reduce); //Optional[10]
    }

    List<Employee> employeeList = Arrays.asList(
            new Employee("xiemaoshu", 23, 5000.0),
            new Employee("lanchaogou", 23, 10000.0),
            new Employee("xxx", 30, 3000.0),
            new Employee("yyy", 40, 2000.0),
            new Employee("yyy", 40, 2000.0)
    );


    @Test
    public void test2(){
        List<Employee> collect = employeeList.stream().collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

        System.out.println("--------------------------");
        Set<Employee> employeeSet = employeeList.stream().collect(Collectors.toSet());
        employeeSet.stream().forEach(System.out::println);

        System.out.println("--------------------------");
        ArrayList<Employee> collect1 = employeeList.stream().collect(Collectors.toCollection(ArrayList::new));
        collect1.stream().forEach(System.out::println);


        Long count = employeeList.stream().collect(Collectors.counting());
        System.out.println(count); //5

        IntSummaryStatistics sum = employeeList.stream().collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println(sum);//IntSummaryStatistics{count=5, sum=156, min=23, average=31.200000, max=40}

        Double avg = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg); //4400.0

    }

    @Test
    public void test3(){
        String collect = employeeList.stream().map(Employee::getName).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

}


@Data
class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

}
