package leetcode.editor.cn.DS.Stack;

//逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
//        平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
//        该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
//        逆波兰表达式主要有以下两个优点：
//        去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
//        适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中

import java.util.*;

public class evalRPN {
    public static void main(String[] args) {
        Solution solution = new evalRPN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            int res = 0;
            Deque<Integer> stack = new LinkedList<Integer>();

            for (String s:tokens){
                switch (s) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-": {
                        int f1 = stack.pop();
                        int f2 = stack.pop();
                        stack.push(f2 - f1);
                        break;
                    }
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/": {
                        int f1 = stack.pop();
                        int f2 = stack.pop();
                        stack.push(f2 / f1);
                        break;
                    }
                    default:
                        stack.push(Integer.parseInt(s));
                        break;
                }


            }
            return stack.peek();
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
