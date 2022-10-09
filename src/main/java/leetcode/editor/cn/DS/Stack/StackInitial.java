package leetcode.editor.cn.DS.Stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 官方定义的栈使用
 * 两种定义stack的方法，一种是使用系统自带的Stack，具有线程安全性；
 * 另一种是使用Deque（双端队列），是官方较为推荐的，其有ArrayDeque和LinkedList这两种实现类
 *      Deque实现类是LinkedList、ArrayDeque、LinkedBlockingDeque
 */
public class StackInitial {
    public static void main(String[] args) {

        Stack<Integer> stack0 = new Stack<>();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new LinkedList<>();

        //不同实现的区别
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();  //推荐写法

        stack.push(8);
        stack.push(9);

        deque.push(8);
        deque.push(9);

        //stack的打印和转换成list的方法
        System.out.println(new ArrayList<>(stack)); // [8,9]
        List<Integer> list1 = stack.stream().collect(Collectors.toList());//[8,9]

        System.out.println(list1);//[8, 9]
        System.out.println(stack);//[8, 9]
        System.out.println(stack.peek());//9
        stack.pop();
        System.out.println(stack); //[8]

        // 推荐使用Deque定义，deque转成ArrayList或stream时保留了“后进先出”的语义
        System.out.println(new ArrayList<>(deque)); // [9,8]
        List<Integer> list2 = deque.stream().collect(Collectors.toList());//[9,8]
        System.out.println(list2);//[9,8]
        System.out.println(deque);//[9,8]
        System.out.println(deque.peek());//9
        deque.pop();
        System.out.println(deque); //[8]
    }

}
