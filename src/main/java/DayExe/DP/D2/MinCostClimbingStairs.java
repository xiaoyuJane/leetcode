package DayExe.DP.D2;

//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
// Related Topics 数组 动态规划 
// 👍 1062 👎 0

public class MinCostClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; //n>=2
        int[] dp = new int[n + 1]; //0到n，dp[n]表示到达n位置所需要的最小话费

        if (n==2) return Math.min(cost[0],cost[1]);
        else {
            dp[1]= 0;
            dp[2]= Math.min(cost[0],cost[1]);
            for (int i = 3; i <=n; i++) {
                dp[i] =  Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
            }
            return dp[n];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}