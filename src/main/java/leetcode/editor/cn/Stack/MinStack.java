package leetcode.editor.cn.Stack;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private Stack<StackNode> stack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            if (stack.isEmpty()) stack.push(new StackNode(val,val));
            else stack.push(new StackNode(val,Math.min(val,getMin())));

        }

        public void pop() {
            if (stack.isEmpty()) throw new IllegalStateException("栈为空！");
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) throw new IllegalStateException("栈为空！");
            return stack.peek().val;

        }

        public int getMin() {
            if (stack.isEmpty()) throw new IllegalStateException("栈为空！");
            return stack.peek().min;

        }


    }

    class StackNode{
        public int val;
        public int min;

        public StackNode(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

