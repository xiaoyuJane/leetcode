package basic.FunctionInterface;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        operatorString("张三", (s) -> System.out.println(s));
        /**
         * 张三
         */

        operatorString("张三", (s) -> System.out.println(s), (s)-> System.out.println(new StringBuilder(s).reverse().toString()));
        /**
         * 张三
         * 三张
         */

        String[] strArray = {"张三,30", "李四,21", "王五,18"};
        printInfo(strArray,
                s1 -> System.out.print("姓名：" + s1.split(",")[0] + ","),
                s2 -> System.out.println("年龄：" + s2.split(",")[1]));

    }

    /**
     *
     * @param name 入参是一个消费型接口
     * @param con  消费型接口
     */
    public static void operatorString(String name, Consumer<String> con) {
        con.accept(name);
    }

    /**
     *
     * @param name 入参
     * @param con1 先执行con1.accept(name);
     * @param con2 再执行con2.accept(name);
     */
    public static void operatorString(String name, Consumer<String> con1,Consumer<String> con2) {
//        con1.accept(name);
//        con2.accept(name);

        //等价
        con1.andThen(con2).accept(name);
    }


    private static void printInfo(String[] strArray, Consumer<String> con1, Consumer<String> con2) {
        for (String str :
                strArray) {
            con1.andThen(con2).accept(str);
        }
    }

}
