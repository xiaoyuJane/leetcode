package competion.single.c306;

/**
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 *
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 20
 * 输出：19
 * 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 * 解释：1 到 5 所有整数都是特殊整数。
 * 示例 3：
 *
 * 输入：n = 135
 * 输出：110
 * 解释：从 1 到 135 总共有 110 个整数是特殊整数。
 * 不特殊的部分数字为：22 ，114 和 131 。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 2 * 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-special-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countSpecialNumbers {
    public static void main(String[] args) {
        Solution solution = new countSpecialNumbers().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countSpecialNumbers(int n) {
            return countSpecialNumbers(0, 0, "" + n, new Integer[("" + n).length()][1 << 10]) - 1;
        }

        private int countSpecialNumbers(int index, int mask, String n, Integer[][] dp) {
            mask = mask < 2 ? 0 : mask;
            if (index == dp.length) {
                return 1;
            } else if (dp[index][mask] == null) {
                int count = (mask & 1 << n.charAt(index) - '0') > 0 ? 0
                        : countSpecialNumbers(index + 1, mask | 1 << n.charAt(index) - '0', n, dp);
                for (int i = 0; i < n.charAt(index) - '0'; i++) {
                    count += (mask & 1 << i) > 0 ? 0 : countSpecialNumbers(index + 1, mask | 1 << i, "9999999999", dp);
                }
                dp[index][mask] = n.equals("9999999999") ? count : null;
                return count;
            }
            return dp[index][mask];
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
