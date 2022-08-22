package basic.annotation;

import lombok.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class demo02 {
    @myAnnotation2(id = 1)
    @myAnnotation3("hi") //value= 可以省略
    public void tes(){
        System.out.println();

    }

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation2{
    //注解的参数放在括号内:参数类型+参数名（）
    String name() default "";
    int age() default 0;
    int id();
    String[] schools() default {"beijing","qinghua"};
}


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation3{
    //如果只有一个参数，可以使用value，此时在使用注解时 value=“”前的value= 可以省略
    String value();
}