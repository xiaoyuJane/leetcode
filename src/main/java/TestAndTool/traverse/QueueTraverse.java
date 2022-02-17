package TestAndTool.traverse;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTraverse {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedBlockingQueue<Integer>();  //单向链表实现的阻塞队列

        // initial queue
        for (int i = 0; i < 5; i++) {
            q.offer(i);
        }
        System.out.println("-------1.集合方式遍历，元素不会被移除-----");
        //集合方式遍历，元素不会被移除
        for (Integer x : q) {
            System.out.println(x);
        }

        System.out.println("-------2.队列方式遍历，元素逐个被移除-----");
        //队列方式遍历，元素逐个被移除
        while (q.peek() != null) {
            System.out.println(q.poll());
        }
    }

    }

