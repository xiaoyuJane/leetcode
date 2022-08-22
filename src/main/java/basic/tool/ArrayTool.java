package basic.tool;

import org.junit.Test;

import java.util.*;

public class ArrayTool {

    @Test
    public void test(){
        int[] arr = new int[]{1,5,3,4};
        System.out.println(arr); //[I@531be3c5

        int[] arrs = new int[5]; //[0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(arrs));


        //打印数组
        String s = Arrays.toString(arr); //将数组类型转换为字符串
        System.out.println(s); //[1,5,3,4]

        //对指定位置进行排序，左闭右开
        int[] ints = {5, 4, 1, 2};
        Arrays.sort(ints,0,2);//左闭右开
        System.out.println(Arrays.toString(ints)); //[1, 3, 4, 5]

        //对数组进行排序
        Arrays.sort(arr); //在原数组基础上修改，不产生新数组
        System.out.println(Arrays.toString(arr)); //[1, 3, 4, 5]

        //打印多维数组
        int[][][] nums = {{{1},{2}},{{3},{4}}};
        System.out.println(Arrays.deepToString(nums)); //[[[1], [2]], [[3], [4]]]

    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,5,3,4};
        int[] arr2 = new int[]{1,5,3,4};

        boolean equals = Arrays.equals(arr, arr2);
        System.out.println(equals); //true

        int[][][] nums = {{{1},{2}},{{3},{4}}};
        int[][][] nums2 = {{{1},{2}},{{3},{4}}};
        System.out.println(Arrays.deepEquals(nums, nums2)); //true
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list); //[1, 2, 3, 4]

        int[] arr = new int[]{1,5,3,4};
        int[] ints = Arrays.copyOf(arr, 2); //[1, 5]
        System.out.println(Arrays.toString(ints));
        int[] ints1 = Arrays.copyOfRange(arr, 0, 2);
        System.out.println(Arrays.toString(ints1)); //[1, 5]
    }

    @Test
    public void test4(){
        int[] arr = new int[]{1,5,3,4};
        Arrays.fill(arr,0,2,3);
        System.out.println(Arrays.toString(arr)); //[3, 3, 3, 4]

        Arrays.fill(arr,0);
        System.out.println(Arrays.toString(arr)); //[0, 0, 0, 0]

    }
}
