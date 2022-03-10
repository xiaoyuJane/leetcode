package leetcode.editor.cn.DS.Queue;

import TestAndTool.tool.MyQueue1;

/**
 * Queue的实现类有LinkedList和PriorityQueue。最常用的实现类是LinkedList
 * 队列通常（但并非一定）以 FIFO（先进先出）的方式排序各个元素.优先级队列和 LIFO 队列（或堆栈）例外
 * 优先级队列根据提供的比较器或元素的自然顺序对元素进行排序，LIFO 队列（或堆栈）按 LIFO（后进先出）的方式对元素进行排序
 * 在 FIFO 队列中，所有的新元素都插入队列的末尾。其他种类的队列可能使用不同的元素放置规则。每个 Queue 实现必须指定其顺序属性。
 *
 */
public class QueueMain {
    public static void main(String[] args) {
        MyQueue1 q = new MyQueue1();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) System.out.println(q.Front());
        q.deQueue();
        if (!q.isEmpty()) System.out.println(q.Front());
        q.deQueue();
        q.enQueue(4);
        if (!q.isEmpty()) System.out.println(q.Front());

    }
}
