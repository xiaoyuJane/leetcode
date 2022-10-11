package DayExe.DS1.D3;

public class maxProfit {
    public static void main(String[] args) {
        Solution solution = new maxProfit().new Solution();
        int[] prices = {7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            int start = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i]<=prices[start]) start=i;
                else max = Math.max(max,prices[i]-prices[start]);
            }
            return max;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
