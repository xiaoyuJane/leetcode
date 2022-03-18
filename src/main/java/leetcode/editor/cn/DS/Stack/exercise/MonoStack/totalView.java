package leetcode.editor.cn.DS.Stack.exercise.MonoStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 描叙：有n个人站队，所有的人全部向右看，个子高的可以看到个子低的发型，给出每个人的身高，问所有人能看到其他人发现总和是多少。
 * 输入：4 3 7 1
 * 输出：2
 *
 * 转化为找当前数字向右查找的第一个大于他的数字之间有多少个数字,并将结果累加
 * 单调递增栈： 从大到小排列的栈
 */
public class totalView {
    public static void main(String[] args) {
        Solution solution = new totalView().new Solution();
        int[] nums = {4,3,7,1};
        System.out.println(solution.totalView(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalView(int[] nums){
            int sum = 0;

            //构造一个新数组，给数组最后一位添加无穷大，方便出栈，走进while循环
            int[] numss = Arrays.copyOf(nums,nums.length+1);
            numss[nums.length] = Integer.MAX_VALUE;

            Deque<Integer> stack = new ArrayDeque<>();
            

            for (int i = 0; i < numss.length; i++) {
                int curr = numss[i];
                while (!stack.isEmpty() && curr>numss[stack.peek()]){
                    int top = stack.pop();
                    sum += (i-top-1);

                }
                stack.push(i);
            }
            return sum;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
