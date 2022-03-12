package leetcode.editor.cn.DS.Stack.exercise;

import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        Solution solution = new isValid().new Solution();
        String s = "()";
        System.out.println(solution.isValid(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for (char c :chars){
                if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c){
                    //遍历s的过程中，如果遇到了右边部分，但是栈完全为空，说明缺失了左边部分值，那肯定就是无效的；
                    //如果栈不为空，但是右边部分遍历的时候，栈中没有左边部分对应的右边部分，说明它达不到自洽，无法脱身
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
