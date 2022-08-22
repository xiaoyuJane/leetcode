package basic.objectDemo;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    @Test
    //访问空对象方法或属性时可能会导致 NullPointerException
    public void test(){
        Optional<User> emptyOpt = Optional.empty();
        System.out.println(emptyOpt.get());//报错NoSuchElementException: No value present
    }

    @Test
    //ofNullable：user对象可能为null
    public void test1(){
        User user = null;
        Optional<User> opt = Optional.ofNullable(user);   //不会报错
    }

    @Test
    //of：user对象不可为null
    public void test2(){
        User user = null;
        Optional<User> opt = Optional.of(user);//user为null时会报NullPointerException
    }

    @Test
    //get() 方法：从 Optional 实例中取回实际对象
    public void test3(){
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.get()); //John
    }

    @Test
    //通过ifPresent()方法验证是否为空
    public void test4(){
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        if(opt.isPresent()){
            System.out.println(opt.get());
        }
    }

    @Test
    //通过ifPresent()方法验证是否为空
    public void test5(){
        User user = new User("jjj@qq.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        if(opt.isPresent()){
            System.out.println(opt.get());
        }
    }

    @Test
    //ifPresent(Consumer<? super T> action)
    // 如果opt对象不为空，就会执行传进来的Consumer参数:
    public void test6(){
        User user = new User("jjj@qq.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);

        List<String> phones=new ArrayList();
        opt.ifPresent( u -> phones.add(u.getPhone()));
        System.out.println(phones); //[1234]
    }

    @Test
    //orElseGet() ：有值的时候返回值；如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并返回其执行结果
    public void test8(){
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElseGet(() -> user2); //如果没有值，它会执行作生产者接口，返回user2
        System.out.println(result.email); //anna@gmail.com

    }

    @Test
    //orElse()：当Optional对象没有值时，返回传递过来的参数值
    // orElse无论有没有值，都会执行里面的参数，如果参数是方法，就可能造成不必要的性能损耗。
    // 而orElseGet()在没有值时，不会触发参数的执行。
    public void test7(){
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2); //user为空就使用user2
        System.out.println(result.email); //anna@gmail.com

    }

    @Test
    //orElseThrow()：在对象为空的时，会抛出异常（可自定义异常）
    public void test9(){
        User user = null;
        User result = Optional.ofNullable(user)
                .orElseThrow( () -> new IllegalArgumentException()); //IllegalArgumentException
    }

    @Test
    //Optional<User> 可以使用map算子
    public void test10(){
        User user = new User("anna@gmail.com", "1234");
        Optional<User> user1 = Optional.ofNullable(user);
        String result= user1
                .map(u -> u.getPhone()).orElse("1111");
        System.out.println(result); //1234

    }

    @Test
    //Optional<User> 可以使用map算子
    //当 getEmail1 方法返回的是Optional对象时， 调用flatMap()
    public void test11(){
        User user = new User("jjj@qq.com", "1234");

        String email = Optional.ofNullable(user)
                .flatMap(u -> u.getEmail1()).orElse("default@gmail.com");
        System.out.println(email); //jjj@qq.com

    }

    @Test

    public void test12(){
        User user = new User("jjj@qq.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("a"));
        System.out.println(result); //Optional.empty

    }




}

@Data
class User {
     String email;
     String phone;

    public User(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    public Optional<String> getEmail1() {
        return Optional.ofNullable(email);
    }

    public String getEmail() {
        return email;
    }
}