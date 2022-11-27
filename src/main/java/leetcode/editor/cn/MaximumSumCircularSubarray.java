package leetcode.editor.cn;
//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 104 
// -3 * 104 <= nums[i] <= 3 * 104 
// 
// Related Topics 队列 数组 分治 动态规划 单调队列 
// 👍 423 👎 0

import ch.qos.logback.classic.spi.EventArgUtil;

import java.util.Arrays;

public class MaximumSumCircularSubarray{
    public static void main(String[] args){
        Solution solution = new MaximumSumCircularSubarray().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //动态规划
    //贪心
  /*  public int maxSubarraySumCircular(int[] nums) {
//        nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n]
//        不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
        int n = nums.length;
        if (n==1) return nums[0];
//        int[][] dp = new int[n][n]; //i和j记录起始位置
        int[] dp = new int[n * n];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=-30001;
        }


        for (int i = 0; i < n; i++) {
            dp[i*i] = nums[i];
            for (int j = i+1; j <=i+n; j++) {
                if (nums[j%n]>=nums[j%n]+dp[i][(j-1)%n]) continue;
                else dp[i][j%n]=nums[j%n]+dp[i][(j-1)%n];
            }
        }
        int res = dp[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;


    }*/

    public int maxSubarraySumCircular(int[] nums){
//        int i,j=0;
//        int res=nums[0];
//        int n = nums.length;
//        if (n==1) return res;
//
//        while (i!=j){
//            for (int k = 1; k < n; k++) {
//                if (nums[k]+nums[k-1])
//            }
//        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}