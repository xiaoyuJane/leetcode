package DayExe.D9;

import java.util.HashMap;
import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        Solution solution = new isValid().new Solution();
        System.out.println(solution.isValid("]"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            HashMap<Character, Character> maps = new HashMap<>(3);
            maps.put('(',')');
            maps.put('[',']');
            maps.put('{','}');

            for (char c : s.toCharArray()) {
                //入栈
                if (maps.containsKey(c)) stack.push(c);
                //出栈
                else {
                    //1 无元素可配对，false
                    if (stack.isEmpty()) return false;
                    Character pop = stack.pop();
                    //2 配对不成功，false
                    if (c!=maps.get(pop)) return false;
                }
            }
            //3 入栈了，无后序元素来配对， false
            if (!stack.isEmpty()) return false;
            return true;


        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
