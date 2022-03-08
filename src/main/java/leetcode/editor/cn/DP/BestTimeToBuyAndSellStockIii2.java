package leetcode.editor.cn.DP;

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

//使用动态规划的方法(状态方程)

public class BestTimeToBuyAndSellStockIii2{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii2().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //状态初始化
        int buy1 = -prices[0]; //进行了一次买入操作的利润值
        int sell1 = 0;  //进行了一次卖出操作的利润值（之前肯定有买）
        int buy2 = -prices[0]; //进行了第二次买入操作的利润值
        int sell2 = 0; //进行了第二次卖出操作的利润值

        for (int i=1;i<prices.length;i++){ //相当于从第二天开始算起，这里没有用数组，而是复用了上面四个变量，减少了空间复杂度
            buy1 = Math.max(buy1,0-prices[i]);  //利润为啥都不做的buy1（上次值），和做了（买入，因为没有卖出操作，所以利润是亏的，是0-price）
            sell1 = Math.max(sell1,buy1+prices[i]); //啥都不做，或者是卖出了
            buy2 = Math.max(buy2,sell1-prices[i]); //买入加price，卖出减price
            sell2 = Math.max(sell2,buy2+prices[i]);
        }
        return sell2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}