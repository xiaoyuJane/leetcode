package basic.classDemo;

import java.util.ArrayList;
import java.util.List;

public class ListCopy {
    public static void main(String[] args) {
//        copy1();
//        copy2();
        copy3();

    }


    /**
     * list2 = list1; //赋值，赋的是引用地址，两个对象指向同一个对象
     * list2只是对list1的引用，并没有重新new一个空间去存放list2的值
     */
    public static void copy1(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> list2 = new ArrayList<>();
        list2 = list1; //赋值，赋的是引用地址，两个对象指向同一个对象

        System.out.println("移除第一个值前:");
        System.out.println("list1:"+list1); //list1:[1, 2, 3, 4]
        System.out.println("list2:"+list2); //list2:[1, 2, 3, 4]

        list2.remove(list2.get(0));

        System.out.println("移除第一个值后:");
        System.out.println("list1:"+list1); //list1:[2, 3, 4]
        System.out.println("list2:"+list2); //list2:[2, 3, 4]
    }

    /**
     *  List<String> list2 = new ArrayList<>(list1); //新建了空间存放list1的值
     *  list1就会重新new一个空间去存放list1的值，实现数据的拷贝
     */
    public static void copy2(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> list2 = new ArrayList<>(list1);


        System.out.println("移除第一个值前:");
        System.out.println("list1:"+list1); //list1:[1, 2, 3, 4]
        System.out.println("list2:"+list2); //list2:[1, 2, 3, 4]

        list2.remove(list2.get(0));
        System.out.println("移除第一个值后:");
        System.out.println("list1:"+list1); //list1:[1, 2, 3, 4]
        System.out.println("list2:"+list2); //list1:[2, 3, 4]

    }

    /**
     * list2.addAll(list1) 实现数据的拷贝
     */
    public  static void copy3(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> list2 = new ArrayList<>();
        list2.addAll(list1);

        System.out.println("移除第一个值前:");
        System.out.println("list1:"+list1);//list1:[1, 2, 3, 4]
        System.out.println("list2:"+list2);//list1:[1, 2, 3, 4]
        list2.remove(list2.get(0));
        System.out.println("移除第一个值后:");
        System.out.println("list1:"+list1);//list1:[1, 2, 3, 4]
        System.out.println("list2:"+list2);//list1:[2, 3, 4]

    }

}
