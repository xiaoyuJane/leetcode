package leetcode.editor.cn.DS.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈的应用 lc739
 */
public class dailyTemperaturesStack {
    public static void main(String[] args) {
        Solution solution = new dailyTemperaturesStack().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures){
            int n = temperatures.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i =0;i<n;i++){
                int temper = temperatures[i];
                //如果找到了匹配点，那就出栈，否则一直在栈里等待匹配
                while (!stack.isEmpty() && temper > temperatures[stack.peek()]){
                    int pre = stack.pop();
                    ans[pre] = i - pre;
                }
                stack.push(i);
            }

            return ans;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
