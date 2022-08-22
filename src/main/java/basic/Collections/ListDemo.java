package basic.Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {


    @Test
    public void add(){
        List<Integer> lists = new ArrayList<Integer>();

        lists.add(1);
        System.out.println(lists);  //[1]

        lists.add(0,0);
        System.out.println(lists); //[0, 1]

        ArrayList<Integer> list2 = new ArrayList<>(lists);
        lists.add(3);
        lists.addAll(list2);
        System.out.println(lists); //[0, 1, 3, 0, 1]

        lists.add(0,-1);
        lists.addAll(0,list2);
        System.out.println(lists); //[0, 1, -1, 0, 1, 3, 0, 1]


    }

    @Test
    public void delete(){

    }
}
