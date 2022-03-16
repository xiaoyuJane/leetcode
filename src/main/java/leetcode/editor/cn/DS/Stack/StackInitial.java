package leetcode.editor.cn.DS.Stack;

import java.util.*;
import java.util.stream.Collectors;

public class StackInitial {
    public static void main(String[] args) {
        //两种定义stack的方法，一种是使用系统自带的Stack，具有线程安全性；
        // 另一种是使用Deque，是官方较为推荐的，其有ArrayDeque和LinkedList这两种实现类
        Stack<Integer> stack0 = new Stack<>();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();  //推荐写法

        stack.push(8);
        stack.push(9);
        deque.push(8);
        deque.push(9);

        //stack的打印和转换成list的方法
        System.out.println(new ArrayList<>(stack)); // [8,9]
        List<Integer> list1 = stack.stream().collect(Collectors.toList());//[8,9]
        System.out.println(list1);

        // 推荐使用Deque定义，deque转成ArrayList或stream时保留了“后进先出”的语义
        System.out.println(new ArrayList<>(deque)); // [9,8]
        List<Integer> list2 = deque.stream().collect(Collectors.toList());//[9,8]
        System.out.println(list2);
    }

}
