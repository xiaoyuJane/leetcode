package basic.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo01 {
    Class c1 = Class.forName("basic.reflection.User");

    public demo01() throws ClassNotFoundException {
    }

    @Test
    //反射拿到构造器，新生成对象
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        User user = (User)c1.newInstance();
        System.out.println(user); //User{name='null', age=0}

        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class);
        User user2 = (User)constructor.newInstance("zz", 18); //User{name='zz', age=18}
        System.out.println(user2);
    }

    @Test
    ///通过反射操作方法
    // Method.invoke
    public void test2() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method setName = c1.getDeclaredMethod("setName", String.class);
        User user = (User)c1.newInstance();
        setName.invoke(user,"zwj");
        System.out.println(user); //User{name='zwj', age=0}

    }

    @Test
    //通过反射操作字段
    // 不能直接操作私有属性，需要关闭程序的安全检测，属性/方法/构造器.setAccessible(true);
    // Field.set
    public void test3() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        User user = (User)c1.newInstance();
        name.set(user,"ss");
        System.out.println(user); //User{name='ss', age=0}
    }


}

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}