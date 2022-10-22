package DayExe.DS2.D14;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class minRemoveToMakeValid {
    public static void main(String[] args) {
        Solution solution = new minRemoveToMakeValid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minRemoveToMakeValid(String s) {
            Set<Integer> indexesToRemove = new HashSet<>();
            Stack<Integer> stack = new Stack<>();

            //通过栈来找配对的
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                }
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        indexesToRemove.add(i);
                    } else {
                        stack.pop();
                    }
                }
            }

            // 将栈中未配对的index加入到set中
            while (!stack.isEmpty()) indexesToRemove.add(stack.pop());

            //取不是被移除的字符加入到结果集中
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!indexesToRemove.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
