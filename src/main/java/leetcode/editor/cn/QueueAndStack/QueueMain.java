package leetcode.editor.cn.QueueAndStack;

public class QueueMain {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
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
