package basic.AbstractClass;

public class Square extends Shape{

    //构造方法继承父类
    public Square(int width, int height) {
        super(width, height);
    }

    //实现求面积方法
    @Override
    public double area() {
        return width*height;
    }
}
