package basic.annotation;

import java.lang.annotation.*;

/**
 * 使用元注解来实现自定义注解
 * 元注解：
 * @Target 可以定义的位置
 * @Retention 注解的生命周期
 * @Documented jdk文档中可现实
 * @Inherited 子类可继承
 */

@Inherited
@Target(value = {ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
}


