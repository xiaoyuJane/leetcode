package DayExe.DS1.D1;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxSubArray {
    public static void main(String[] args) {
        Solution solution = new maxSubArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用动态规划的思想
        //前一个之和大于0。对于我的和积累有用，加上
        //前一个之和小于0。对于我的和积累无用，保底为我自己
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i-1]>0) dp[i] = nums[i]+dp[i-1]; //前一个之和大于0。对于我的和积累有用，加上
                else dp[i] = nums[i]; //前一个之和小于0。对于我的和积累无用，保底为我自己
            }

            int res = dp[0];
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(dp[i],res);
            }
            return res;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
