package leetcode.editor.cn.BFS.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    //滑动的窗口大小
    private int size ;
    //移动平均值
    private double average ;
    //使用队列存储
    private Queue<Integer> queue;

    //构造函数
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
        this.average = 0;
    }

    public double next(int val) {
        if (queue.size() >= this.size) {
            queue.poll();
        }
        queue.offer(val);
        int win = queue.size();

        double sum = 0;
        for (Integer item : queue){
            sum +=item;
        }
        this.average = sum/win;
        return this.average;

    }
}
