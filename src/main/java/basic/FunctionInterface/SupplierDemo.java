package basic.FunctionInterface;

import org.junit.Test;

import java.util.function.Supplier;

public class SupplierDemo {
    @Test
    public void test(){
        String s = getString(()->"张三");
        int i = getInteger(()->18);
        System.out.println(s+","+i);

    }

    //定义一个方法，返回一个字符串数据
    private static String getString(Supplier<String> sup){
        return sup.get();
    }

    //定义一个方法，返回一个整数数据
    private static Integer getInteger(Supplier<Integer> sup){
        return sup.get();
    }
}
