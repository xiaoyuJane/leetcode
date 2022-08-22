package basic.Generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class reflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor();
        Person person = constructor.newInstance();
        System.out.println(person);
    }
}

class Person{
    int age;


}