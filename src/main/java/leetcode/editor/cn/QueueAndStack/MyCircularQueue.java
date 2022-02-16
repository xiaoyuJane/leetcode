package leetcode.editor.cn.QueueAndStack;


public class MyCircularQueue {


    private int[] data;
    private  int head;
    private  int tail;
    private int len;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.head = k;
        this.tail = k;
        this.len = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()){
            head = 0;
            tail = 0;
            data[tail] = value;
        }else{
            tail = (tail+1)%len;
            data[tail] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = len;
            tail = len;
        } else {
            head = (head+1)%len;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        else return data[head];

    }

    public int Rear() {
        if (isEmpty()) return -1;
        else return data[tail];
    }

    public boolean isEmpty() {
        return head==len ;

    }

    public boolean isFull() {
        if (len ==1) return head == 0;
        else return (tail+1)%len == head;

    }
}
