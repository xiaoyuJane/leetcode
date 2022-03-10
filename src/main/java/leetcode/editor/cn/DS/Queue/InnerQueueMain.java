package leetcode.editor.cn.DS.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java内置的队列实现
 * 队列的数据结构为Queue<T>,内置实现是LinkList
 * 队列的获取队首元素为q.peek()
 * 队列入队操作位q.offer(x)
 * 队列的出队为q.poll()
 * 队列的长度为q.size()
 */

public class InnerQueueMain {
    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();

        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());

        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);

        // 4. Pop an element.
        q.poll();

        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
