package leetcode.editor.cn.algorithm.DP;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 2868 👎 0

import java.util.Arrays;

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //数学归纳法解决动态规划问题
        // 我们设计动态规划算法，需要一个 dp 数组，我们可以假设 dp[0...i-1] 都已经被算出来了，然后问自己：怎么通过这些结果算出 dp[i]？
        // 还有一点是需要确定dp数组的含义，关于子序列问题的套路，dp数组的含义为：以 nums[i] 这个数结尾的最长递增子序列的长度，从而得到base case为 dp[i]=1
        //继续分解，可以得到所求的数组的最大子序列应该是dp数组中的最大值
    public int lengthOfLIS(int[] nums) {
        int[] dp  = new int[nums.length];
        Arrays.fill(dp,1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                //我只需要找之前比我小的，加上我自身，就可以构成一个子序列，求取单个的最长子序列
                if (nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1); //状态转移方程
            }
        }

        //从dp数组中再找最长子序列
        int res =0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}