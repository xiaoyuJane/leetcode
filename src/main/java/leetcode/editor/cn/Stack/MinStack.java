package leetcode.editor.cn.Stack;

import java.util.Stack;

/**
 * 想要常量化时间复杂度求取栈中最小值，那就设置一个数据结构实时存储min值，这样就能从peek处拿到节点中的min值了
 */

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

/**
 * 针对题目要求，自定义了栈的数据结构，用min来存储栈中的最小值，这样就能实现常数时间获取最小值了
 */
class StackNode{
        public int val;
        public int min;

        public StackNode(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

