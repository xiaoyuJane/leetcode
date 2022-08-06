package basic.FunctionInterface;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        convert("18",s -> Integer.parseInt(s));
        //等价使用引用
        convert("18", Integer::parseInt);

        convert(20, integer -> String.valueOf(integer + 18));
        convert("245", Integer::parseInt, integer -> String.valueOf(integer + 18));
    }


    /**
     * convert测试方法把一个字符串转换成int类型(转换过程由fun指定)，在控制台输出
     * @param s Function的入参
     * @param fun Function函数式接口，它的apply方法由使用者指定和实现
     */
    private static void convert(String s, Function<String,Integer> fun){
        Integer integer = fun.apply(s);
        System.out.println(integer);
    }

    //定义一个方法，把int类型数据加上一个整数之后，转换为字符串在控制台输出
    private static void convert(int i, Function<Integer, String> fun) {
        String s = fun.apply(i);
        System.out.println(s);
    }

    //定义一个方法，把一个字符串转换int类型，
    // 把int类型的数据加上一个整数后，转换成字符串在控制台输出
    private static void convert(String s, Function<String, Integer> fun1, 	Function<Integer, String> fun2) {
        String s1 = fun2.apply(fun1.apply(s));
        System.out.println(s1);
    }

}
