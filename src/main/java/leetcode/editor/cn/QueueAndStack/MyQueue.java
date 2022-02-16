package leetcode.editor.cn.QueueAndStack;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int p_start;

    public MyQueue(){
        this.data = new ArrayList<Integer>();
        this.p_start = 0;
    }

    public boolean enQueue(int x){
        data.add(x);
        return true;
    }

    public boolean isEmpty(){
        //因为出队的元素实际上并没有被删除，只是front指针往后移了，data.size并不是真实的队列中的元素个数
        return p_start >= data.size();
    }

    public boolean deQueue(){
        if (isEmpty()) return false;
        p_start++;
        return true;
    }


    public int Front(){
        return data.get(p_start);
    }

}
