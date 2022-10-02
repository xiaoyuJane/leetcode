package DayExe;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    @Test
    public void set(){
        Integer[] nums = {0,0,1,1,1,2,2,3,3,4};
        Set<Integer> set = Arrays.stream(nums).collect(Collectors.toSet());

        //debug输出
        for (Integer integer : set) {
            System.out.println(integer);//【输出：1234  】
        }
    }


    @Test
    public void set1(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //debug输出
        for (Integer integer : set) {
            System.out.println(integer);//【输出：1234  】
        }


    }

    @Test
    public void set2(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        boolean res = nums.length == set.size();
        System.out.println(res);
    }

    @Test
    public void sort1(){
        int[] vals = {1,3,2,1,3};
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        Arrays.sort(edges, (o, p) -> Math.max(vals[o[0]], vals[o[1]]) - Math.max(vals[p[0]], vals[p[1]]));
        System.out.println(Arrays.toString(edges));
    }

    @Test
    //十进制和二进制的互相转换
    public void test(){
        //System.out.println(Math.pow(2, 1)); //2的1次方
        int number = 2;
        String s = Integer.toString(number,2); //十进制转换为二进制
        System.out.println(s); //10
        System.out.println(Integer.toBinaryString(number));//10

        String ss="0011";
        int i = Integer.parseInt(ss, 2);
        System.out.println(Integer.parseInt(ss,2));//3
    }
}
