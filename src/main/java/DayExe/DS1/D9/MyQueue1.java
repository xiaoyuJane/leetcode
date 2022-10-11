package DayExe.DS1.D9;

import java.util.Stack;

public class MyQueue1 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue1().new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int peek = myQueue.peek();// return 1
        System.out.println(peek);
        int pop = myQueue.pop();// return 1, queue is [2]
        System.out.println(pop);
        boolean empty = myQueue.empty();// return false
        System.out.println(empty);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
         Stack<Integer> in;
         Stack<Integer> out;

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        // 将元素 x 推到队列的末尾
        public void push(int x) {
            transIn();
            in.push(x);

        }
        // 从队列的开头移除并返回元素
        public int pop() {
            if (!in.isEmpty()) transOut();
            return out.pop();


        }
        // 返回队列开头的元素
        public int peek() {
            if (!in.isEmpty()) transOut();
            return out.peek();
        }
        // 如果队列为空，返回 true ；否则，返回 false
        public boolean empty() {
            if (!in.isEmpty()) transOut();
            return out.isEmpty();

        }

        private void transOut(){
            while (!in.isEmpty()){
                Integer pop = in.pop();
                out.push(pop);
            }
        }

        private void transIn(){
            while (!out.isEmpty()){
                Integer pop = out.pop();
                in.push(pop);
            }
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
