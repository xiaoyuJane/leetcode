package leetcode.editor.cn.DS.Queue.MonoQueue;
//有  7 6 8 12 9 10 3 七个数字，现在让你找出范围（ i-3，i ） 的最小值。


import java.util.LinkedList;
import java.util.Queue;

public class FindWindowMin {
    public static void main(String[] args) {
        Solution solution = new FindWindowMin().new Solution();
        int[] nums = {7,6,8,12,13,10,3};
        System.out.println(solution.FindWindowMin(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //求取区间范围内的最小值，则构造单调递增队列，保证队首始终为最小值
        public int FindWindowMin(int[] nums){
            Queue<Integer> min = new LinkedList<>();
            int size = 3;
            int res = nums[0];

            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                //遇到了小的
                while (!min.isEmpty() && curr < min.peek()) min.poll();
                min.offer(curr);
                if (min.size()>size) min.poll();
                res = Math.min(res,min.peek());
            }
            return res;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
