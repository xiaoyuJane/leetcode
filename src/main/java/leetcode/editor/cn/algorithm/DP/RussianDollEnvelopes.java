package leetcode.editor.cn.algorithm.DP;

//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 105 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 105 
// 
// Related Topics 数组 二分查找 动态规划 排序 
// 👍 832 👎 0

import java.util.Arrays;

public class RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //二维数组的排序
        Arrays.sort(envelopes,((o1, o2) -> (o1[0]==o2[0]? o2[1]-o1[1]: o1[0]-o2[0])));

        //转化为了一维数组，对高度数组进行求最长子序列
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i]= envelopes[i][1];
        }

        //构造每个位置i的dp数组
        int[] dp = new int[heights.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (heights[i]>heights[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }

        //在dp数组中求最值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}