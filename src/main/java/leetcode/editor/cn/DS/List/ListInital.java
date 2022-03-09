package leetcode.editor.cn.DS.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListInital {
    public static void main(String[] args) {
        // 1 常规
        System.out.println("1.normal inital of List:");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("get list:" +list);  //get list:[1, 2, 3]


        // 2 Arrays.asList 静态方法
        System.out.println("2.Arrays inital of List which is imutable:");
        //*****如此生成的list不可变
        List<String> list1 = Arrays.asList("1","2","3");
        System.out.println("get list1:" +list1); //get list1:[1, 2, 3]

        // 2 ArrayList<>(Arrays.asList("1","2","3")) 包装Arrays.asList
        System.out.println("3.Arrays inital of List by ArrayList can dynamic add elements:");
        //如果要可变，需要用ArrayList包装一下
        List<String> list2 = new ArrayList<>(Arrays.asList("1","2","3"));
        list2.add("2");
        System.out.println("get list2:" +list2); //get list2:[1, 2, 3, 2]



        //3.Collections 工具类
        //*****如此生成的list不可变
        List<String> list3 = Collections.nCopies(3,"1");
        System.out.println("get list3:" +list3); //get list3:[1, 1, 1]
        //如果要可变，需要用ArrayList包装一下
        List<String> list33 = new ArrayList<>(Collections.nCopies(3,"3"));
        list33.add("3");
        System.out.println("get list33:" +list33); //get list33:[3, 3, 3, 3]

        //4.匿名内部类
        List<String> list5= new ArrayList<>(){{
            add("1");
            add("2");
            add("3");
        }};
        System.out.println("get list5:" +list5); //get list5:[1, 2, 3]

        //5.Java8 stream
        List<String> list6= Stream.of("1","2","3").collect(Collectors.toList());
        System.out.println("get list6:" +list6); //get list6:[1, 2, 3]

        //6.Java9 List.of
        List<String> list7=List.of("1","2","3");
        System.out.println("get list7:" +list7); //get list7:[1, 2, 3]














    }


}
