package basic.streamDemo;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekDemo {
    @Test
    //peek()方法存在的主要目的是用调试，通过peek()方法可以看到流中的数据经过每个处理点时的状态
    public void test_peekDebug() {
        Person a = new Person("a", 18);
        Person b = new Person("b", 23);
        Person c = new Person("c", 34);

        Stream<Person> persons = Stream.of(a, b, c);
        persons.filter(person -> person.getAge() < 30)
                .peek(person -> System.out.println("filter " + person))
                .map(person -> new Person(person.getName() + " map", person.getAge()))
                .peek(person -> System.out.println("map " + person))
                .collect(Collectors.toList());
    }

    @Test
    //peek()在需要修改元素内部状态的场景也非常有用
    public void test_modifyInnerState() {
        Person a = new Person("a", 18);
        Person b = new Person("b", 23);
        Person c = new Person("c", 34);
        Stream<Person> persons = Stream.of(a, b, c);
        persons.peek(person -> person.setName(person.getName().toUpperCase()))
                .forEach(System.out::println);
    }
}


class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
