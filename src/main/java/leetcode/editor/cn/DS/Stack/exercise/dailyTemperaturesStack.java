package leetcode.editor.cn.DS.Stack.exercise;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *  
 *
 * 提示：
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * 相关标签
 * 栈
 * 数组
 * 单调栈

 */
/**
 * 单调栈的应用 lc739
 * 最近的大于它的值，使用栈
 */
public class dailyTemperaturesStack {
    public static void main(String[] args) {
        Solution solution = new dailyTemperaturesStack().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures){
            int n = temperatures.length;
            int[] ans = new int[n]; //默认值为0，满足条件才不为0
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i =0;i<n;i++){
                int temper = temperatures[i];
                //如果找到了匹配点，那就出栈，否则一直在栈里等待匹配
                while (!stack.isEmpty() && temper > temperatures[stack.peek()]){
                    int pre = stack.pop();
                    ans[pre] = i - pre;
                }
                stack.push(i); //空栈入栈，或者小于等于前值，入栈，都属于不满足出栈条件的就进去，进去的是下标值
            }

            return ans;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
