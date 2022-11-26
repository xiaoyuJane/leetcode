package DayExe.DP.D3;

//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]+ 1 的元素。
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 数组 哈希表 动态规划 
// 👍 697 👎 0

public class DeleteAndEarn{
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        //处理边界值
        if (nums.length == 1) return nums[0];

        //找到数组的最大值
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        //构造辅助数组，下标为从1到max，值为出现的次数
        int[] frequency = new int[max + 1];
        //遍历nums获得辅助数组的值
        for (int num : nums) {
            frequency[num]++;
        }

        //动态规划的递推方程来了
//        如果你不删除当前位置的数字，那么你得到就是前一个数字的位置的最优结果。
//        如果你觉得当前的位置数字i需要被删，那么你就会得到i - 2位置的那个最优结果加上当前位置的数字乘以个数。
        if(max==1) return frequency[1] * 1;
        if(max== 2) return Math.max( frequency[1] * 1, frequency[2] * 2);
        int[] dp = new int[max + 1];
        //base case
        dp[1] = frequency[1]*1;  //因为获取点数后要删去它左右两边的数，如果都是1，那么dp得到的值就是频次*1
        dp[2] = Math.max(dp[1],frequency[2]*2); //不删它 和删除它
        //      动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * frequency[i]);
        }
        return dp[max];


    }


}
//leetcode submit region end(Prohibit modification and deletion)

}