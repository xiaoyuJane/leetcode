package basic.PackageDemo;

import org.junit.Test;

public class TransDemo {

    public static void main(String[] args) {
//        packageTest();
//        parseIntTest();
        parseLongTest();
    }

    //自动装箱和拆箱
    public static void packageTest(){
        Integer i = new Integer(10);// 创建包装类对象
        Integer ii = 10; // 自动打包

        System.out.println(i+10); // 在使用上，int 和Integer 其实没有区别，可以互相使用
        System.out.println(ii+10);

        int j = ii;// 自动解包
        System.out.println(j+100);
    }


    // 字符串转成int的唯一方案
    public static void parseIntTest(){
        String a = "12";
        String b = "34";
        System.out.println(a+b); // 1234

        // 转型:
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        System.out.println(c+d); // 46
    }

    public static void parseLongTest(){
        // 转成long类型
        long l = Long.parseLong("1234567");
        System.out.println(l);

        String e = "1.25";
        double f = Double.parseDouble(e);
        System.out.println(f*6); // 7.5

    }

    @Test
    public void test(){
        //整数型
        int byteSize = Byte.SIZE; //1 Byte
        System.out.println("byte size: " + (byteSize/8) + " Byte" );

        int shortSize = Short.SIZE; //2 Byte
        System.out.println("short size: " + (shortSize/8) + " Byte" );

        int intSize = Integer.SIZE; //4 Byte
        System.out.println("int size: " + (intSize/8) + " Byte" );

        int longSize = Long.SIZE; //8 Byte
        System.out.println("long size: " + (longSize/8) + " Byte" );


        //浮点型
        int floatSize = Float.SIZE; //4 Byte
        System.out.println("float size: " + (floatSize/8) + " Byte" );

        int doubleSize = Double.SIZE; //8 Byte
        System.out.println("double size: " + (doubleSize/8) + " Byte" );

        int charSize = Character.SIZE;
        System.out.println("char size: " + (charSize/8) + " Byte" );

    }

}
