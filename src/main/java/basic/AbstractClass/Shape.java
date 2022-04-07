package basic.AbstractClass;

/**
 * 一个类中没有包含足够的信息来描绘一个具体的对象，那么这样的类称为抽象类
 * 如果一个方法被声明为抽象的，那么这个类也必须声明为抽象的
 * 一个抽象类中，可以有 0~n 个抽象方法，以及 0~n 个具体方法
 *
 */


//含有抽象方法的类也必须用abstract来修饰，从而成为抽象类
public abstract class Shape {
    public int width;
    public int height;

    Shape(int width, int height){
        this.width = width;
        this.height = height;
    }

    //abstract定义抽象方法,abstract 关键字只能用于普通方法，不能用于 static 方法或者构造方法中
    public abstract double area();
}
