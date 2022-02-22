package leetcode.editor.cn.List;


import java.util.Arrays;

/**
 * java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。
 *
 */
public class ArrayMain {
    public static void main(String[] args) {

        //Arrays.toString
        int[] intArray = {10,20,30};
        String intStr = Arrays.toString(intArray); //将参数数组变成字符串,按照默认格式:[元素1,元素2,元素3…]
        System.out.println(intStr); //[10, 20, 30]


        //Arrays.sort
        int[] array1 = {2,3,1,5,4};
        Arrays.sort(array1); //默认情况下是从小到大排列
        System.out.println(Arrays.toString(array1)); //[1, 2, 3, 4, 5]

        String[] array2 = {"bbb","cc","a","ddd"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2)); //[a, bbb, cc, ddd] 默认按照字母升序来

        //Arrays.equals
        int[] a = new int[] { 3, 4, 5, 6 };
        int[] a2 = new int[] { 3, 4, 5, 6 };
        System.out.println("a数组和a2数组是否相等：" + Arrays.equals(a, a2)); //true

        //Arrays.copyOf 通过复制a数组，生成一个新的b数组
        int[] b = Arrays.copyOf(a, 6);
        System.out.println(Arrays.toString(b)); //[3, 4, 5, 6, 0, 0]
        System.out.println("a数组和b数组是否相等：" + Arrays.equals(a, b)); //false

        //Arrays.fill 将b数组的第3个元素（包括）到第5个元素（不包括）賦值为1
        Arrays.fill(b, 2, 4, 1); //[3, 4, 1, 1, 0, 0]
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b)); //[0, 0, 1, 1, 3, 4]







    }


}
