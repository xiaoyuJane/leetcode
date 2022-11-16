package leetcode.editor.cn.algorithm.DP;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 2199 👎 0


import java.util.Arrays;

public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] coins = {1,2,5};
        int amount=100;
        System.out.println(solution.coinChange(coins,amount));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //可以自底向上使用 dp table 来消除重叠子问题
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;

        // 外层 for 循环在遍历所有状态的所有取值,从小到大
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                //状态转移方程在此
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }



    /**
     * 这个问题是动态规划问题，因为它具有「最优子结构」的。要符合「最优子结构」，子问题间必须互相独立
     * 选择会影响状态，状态应该向base case靠近
     * 我们这里讲的是自顶向下的解法，所以会有一个递归的 dp 函数，
     * 一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。
     * 就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。
     * @param coins
     * @param amount
     * @return
     */

   int[] memo;
    public int coinChange1(int[] coins, int amount) {
        //增加备忘录
        memo = new int[amount+1];
        Arrays.fill(memo,-666);
        //使用dp做递归函数
        return dp(coins, amount);
    }

    /**
     *
     * @param coins 硬币数值数组
     * @param amount 总金额
     * @return 凑足amout需要最少的硬币数量
     */
    private  int dp(int[] coins, int amount){
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        //查找备忘录
        if (memo[amount]!=-666) return memo[amount];

        //未找到，走以下流程
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        memo[amount] =  res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}