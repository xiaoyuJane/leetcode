package leetcode.editor.cn.algorithm.floyd_2pointer;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 984 👎 0

//二分法，
// 来特殊处理要求个数为2的情况
// 从左到右，表示买入卖出顺序的最大利润
// 从右到左，表示卖出前推买入的最大利润
// 计算数组中的最大值

public class BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length ==1) return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0]=0;
        right[prices.length-1]=0;

        int min=prices[0];
        for (int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            left[i]=Math.max(left[i-1],prices[i]-min);
        }

        int max=prices[prices.length-1];
        for (int i=prices.length-2;i>=0;i--){
            max=Math.max(max,prices[i]);
            right[i]=Math.max(right[i+1],max-prices[i]);
        }

        int profit=0;
        for (int i=1;i<prices.length;i++){
            profit = Math.max(profit,left[i]+right[i]);
        }

        return profit;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}