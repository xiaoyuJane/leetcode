package leetcode.editor.cn.DS.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.jianshu.com/p/7eee157f74fc
 * List转换成数组，可以使用List的toArray()或者toArray(T[] a)方法。
 * 数组转换成List，可以使用Arrays.asList()或者Collections.addAll()方法。
 * 如果仅仅为了打印数组，不需要把数组转换成List，可以使用Arrays.toString()方法。
 *
 */
public class List2Array {
    public static void main(String[] args) {

        //***List转换成数组

        //1.无参的toArray()方法，其实其默认的类型为Object[]，编译不会报错但是运行会报错
        List<String> strList = new ArrayList<>();
        strList.add("list-a");
        strList.add("list-b");
        // String[] strArray = (String[]) strList.toArray(); 会报错 不能将Object[]转化为String[]
        Object[] strArray = strList.toArray(); //正确写法，但是没啥用，是个Object[]

        //2.支持泛型的toArray方法 <T> T[]    toArray(T[] a);  泛型参数不能为基本类型
        List<String> strList2 = new ArrayList<>();
        strList2.add("list-a");
        strList2.add("list-b");
        String[] str2Array = strList2.toArray(new String[strList2.size()]); //接收一个类型为String的数组


        //***数组转换为List
        //1 Arrays.asList
        String[] strArray3 = { "array-a", "array-b" };
        List<String> strList3 = Arrays.asList(strArray3); //返回值是java.util.Arrays类中一个私有静态内部类java.util.Arrays.ArrayList,
//      strList.add("array-c"); // 会报错，这个并非java.util.ArrayList类，不支持添加add()或删除remove()方法
        List<String> strListNew = new ArrayList<>(strList3);
        strListNew.add("array-c");

        //2.使用Collections.addAll()方法
        String[] strArray4 = { "array-a", "array-b" };
        List<String> strList4 = new ArrayList<>(strArray4.length);
        Collections.addAll(strList4, strArray4);  // 把String[]  放入List<String>
        strListNew.add("array-c");  //可以使用add方法




    }


}
