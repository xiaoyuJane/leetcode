package leetcode.editor.cn.DS.Stack;

//单调栈
// 单调栈中存放的数据是有序的，所以单调栈也分为单调递增栈和单调递减栈
// 单调递增（从顶到底递增）栈：栈顶数据始终最小
// 单调递减栈：栈顶数据始终最大

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonousStack {
    public static void main(String[] args) {
        Solution solution = new MonotonousStack().new Solution();
        int[] nums = {10,3,7,4,12};
        solution.MonotonousStack(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //单调递增栈：栈顶元素最小，保证栈中递减的顺序
        public void MonotonousStack(int[] nums){
            Deque<Integer> stack = new ArrayDeque<>();

            //遍历数组
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                //比较当前元素与栈顶元素，
                //如果当前元素大于栈顶元素，要保证单调递增栈，保证栈顶元素最小，只能将栈顶元素出栈进行调整，
                //while循环不停出栈，直到当前元素<=栈顶元素
                while (!stack.isEmpty() && curr > stack.peek()){
                    stack.pop();
                    System.out.println("调整后："+stack.toString());
                }
                //当前元素进栈
                stack.push(curr);
                System.out.println("调整前："+stack.toString());
            }
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
