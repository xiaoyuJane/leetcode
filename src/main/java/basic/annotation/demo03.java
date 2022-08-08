package basic.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 通过反射获取注解的值
 */

public class demo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class user = Class.forName("basic.annotation.User");

        //通过反射获得注解
        Annotation[] annotations = user.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation); //@basic.annotation.Table(value="db_user")
        }

        //通过反射获得类注解的value,然后作为数据库的值插入
        Table table = (Table)user.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value); //db_user

        //通过反射获得字段注解的value,然后作为数据库的值插入
        Field f = user.getDeclaredField("name");
        Filed field = f.getAnnotation(Filed.class);
        String col = field.columnName(); //name
        int length = field.length(); //256
        String type = field.type(); //varchar

        System.out.println(col);
        System.out.println(length);
        System.out.println(type);

    }

}

/**
 * 类名的注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Filed{
    String columnName();
    String type();
    int length();

}

@Table("db_user")
class User{
    @Filed(columnName = "name",type = "varchar",length = 256)
    private String name;

    @Filed(columnName = "age",type = "int",length = 10)
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
