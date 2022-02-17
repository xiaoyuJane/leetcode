package leetcode.editor.cn;

import leetcode.editor.cn.QueueAndStack.MovingAverage;

public class QueueAndStackCase {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1);
        movingAverage.next(10);
        movingAverage.next(3);
        movingAverage.next(5);
    }
}
