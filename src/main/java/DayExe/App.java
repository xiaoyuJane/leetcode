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
}
