package leetcode.editor.cn;

//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limt 。
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 队列 数组 有序集合 滑动窗口 单调队列 堆（优先队列） 
// 👍 233 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit{
    public static void main(String[] args) {
        Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int left = 0, right = 0, res = 0;

        while (right < nums.length){
            //构造单调队列，维护最大值和最小值
            int offer = nums[right];
            while (!max.isEmpty() && offer > max.peekLast()) max.pollLast();
            while (!min.isEmpty() && offer < min.peekLast()) min.pollLast();
            max.offerLast(offer);
            min.offerLast(offer);

            //不满足条件的时候，left移出，做处理
            while ((max.peekFirst() - min.peekFirst()) > limit){
                int poll = nums[left];
                //出队
                if (min.peekFirst() == poll) min.pollFirst();
                if (max.peekFirst() == poll) max.pollFirst();
                //往后移动
                left++;
            }
            //满足条件，计算最大区间，并对right右移
            res = Math.max(res,right-left+1);
            right ++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}