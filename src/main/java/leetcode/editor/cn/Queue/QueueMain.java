package leetcode.editor.cn.Queue;

import TestAndTool.tool.MyQueue1;

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
