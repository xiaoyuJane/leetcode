package leetcode.editor.cn.DP;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 
// 👍 4260 👎 0

//思路：分治法，从第一个元素开始。如果后面的元素和前面元素相加大于自身，加入队列并且最大值为相加的值；
// 如果不大于自身，那么就从自身开始算起，前面的就放弃

public class MaximumSubarray{
    public static void main(String[] args) {

        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = solution.maxSubArray1(nums);
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //动态规划，对于最大值dp数组来说，dp[k],取决于dp[k-1]，或者是k自成一段，
        // 写出方程为 dp[k] = max(dp[k-1]+nums[k],nums[k])

    public int maxSubArray(int[] nums) {
        int n = nums.length;
       int[] dp = new int[n];
       dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
        }

        int res = dp[0];
        for (int item :dp){
            res = Math.max(res,item);
        }

        return res;

    }

    //使用两个变量来代替数组
    public int maxSubArray1(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for (int i=1;i<nums.length;i++){
            sum = Math.max(nums[i],nums[i]+sum);
            result = Math.max(result,sum);
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}