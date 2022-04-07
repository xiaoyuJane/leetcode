package leetcode.editor.cn.DS.List;

import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list); //[1, 2, 3]

        //拷贝一个list
        List<Integer> list1 = new LinkedList<>(list);
        System.out.println(list1); //[1, 2, 3]


        list.remove(list.size()-1);
        System.out.println(list);  //[1, 2]


    }
}
