package leetcode.editor.cn.DS.Queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * double ended queue 双端队列的用法
 * Deque是一个双端队列接口，继承自Queue接口
 * Deque的实现类是LinkedList、ArrayDeque、LinkedBlockingDeque，其中LinkedList是最常用的
 *
 * Deque有三种用途
 * 1.普通队列(一端进另一端出):
 * Queue queue = new LinkedList()  或Deque deque = new LinkedList()
 * 2.双端队列(两端都可进出)
 * Deque deque = new LinkedList()
 * 3.堆栈(Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()。)
 * Deque deque = new LinkedList()
 *
 * 推荐offer pull peek相关的操作。因为这些操作用特殊值代替了抛出异常的方式
 */
public class DequeUsage {
    public static void main(String[] args) {

        Deque<String> deque1 = new LinkedList<String>();
        deque1.offerFirst("2");    //offerFirst () 从首部添加
        deque1.offerLast("7");   //offerLast () 从尾部添加
        System.out.println(deque1); //[2, 7]
        System.out.println(deque1.peekFirst()); //2
        System.out.println(deque1.peekLast()); //7
        deque1.pollFirst();
        System.out.println(deque1); //[7]
        deque1.pollLast();
        System.out.println(deque1); //[]


        System.out.println("===============queue============");
        //1.as noraml queue
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(1);  // 入队 queue.offer(x)
        queue.offerLast(2);
        queue.offerLast(3);
        System.out.println(queue); //[1, 2, 3]
        System.out.println(queue.peekFirst()); // 1  队首 queue.peek()
        queue.pollFirst();  //出队 queue.poll(x)
        System.out.println(queue); //[2, 3]

        System.out.println("===============stack============");
        //2. as stack
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(1);  //入栈 stack.push(x)
        stack.addFirst(2); //左边是栈顶，右边是栈底，始终操作左边的栈顶，即first
        stack.addFirst(3);
        System.out.println(stack); //[3, 2, 1]
        System.out.println(stack.peekFirst()); //栈顶元素 stack.peek();  //3
        stack.removeFirst();  //出栈  stack.pop()
        System.out.println(stack);  //[2, 1]

        System.out.println("===============deque============");
        //2. as deque
        //主要用offerFirst pollFirst peekFirst , offerLast pollLast peekLast
        Deque<String> deque = new LinkedList<String>();
        // add elements to the queue using various methods
        deque.addFirst("1");      //addFirst ()
        deque.offerFirst("2");    //offerFirst () 从首部添加
        deque.push("3");         //push () 从首部添加

        deque.addLast("4");     //addLast ()
        deque.offer("5");        //offer () 从尾部添加
        deque.add("6");           //add () 从尾部添加
        deque.offerLast("7");   //offerLast () 从尾部添加

        System.out.println("Initial Deque:");
        System.out.print(deque + " ");

        Iterator iterator = deque.iterator();
        while (iterator.hasNext())
            System.out.print(" " + iterator.next());

        Iterator reverse = deque.descendingIterator();
        System.out.println("\n\nDeque contents using Reverse Iterator:");
        while (reverse.hasNext())
            System.out.print(" " + reverse.next());

        System.out.println("\n\nDeque Peek:" + deque.peek());
        System.out.println("\nDeque,After peek:" + deque);

        deque.removeFirst();        //removeFirst ()
        deque.removeLast();         //removeLast ()
        System.out.println("\nDeque, after removing "  + "first and last elements: " + deque);


    }


}
