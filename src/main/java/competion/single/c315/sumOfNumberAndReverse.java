package competion.single.c315;

/**
 * 输入：num = 443
 * 输出：true
 * 解释：172 + 271 = 443 ，所以返回 true 。
 * 示例 2：
 *
 * 输入：num = 63
 * 输出：false
 * 解释：63 不能表示为非负整数及其反转后数字之和，返回 false 。
 * 示例 3：
 *
 * 输入：num = 181
 * 输出：true
 * 解释：140 + 041 = 181 ，所以返回 true 。注意，反转后的数字可能包含前导零。
 */
public class sumOfNumberAndReverse {
    public static void main(String[] args) {
        Solution solution = new sumOfNumberAndReverse().new Solution();
        int num = 63;
        System.out.println(solution.sumOfNumberAndReverse(num));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            if (num==0) return true;
            for (int i = num/2; i < num; i++) {
                if (i+reverse(i) == num) return true;
            }
            return false;

        }
        private int reverse(int num){
            StringBuilder s = new StringBuilder(String.valueOf(num));
            String reverse = s.reverse().toString();
            reverse.trim();
            return Integer.parseInt(reverse);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
