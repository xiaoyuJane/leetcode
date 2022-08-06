package basic.PackageDemo;

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

}
