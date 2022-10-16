package competion.single.c315;

import java.util.HashSet;

/**
 * 示例 1：
 *
 * 输入：nums = [1,13,10,12,31]
 * 输出：6
 * 解释：反转每个数字后，结果数组是 [1,13,10,12,31,1,31,1,21,13] 。
 * 反转后得到的数字添加到数组的末尾并按斜体加粗表示。注意对于整数 10 ，反转之后会变成 01 ，即 1 。
 * 数组中不同整数的数目为 6（数字 1、10、12、13、21 和 31）。
 * 示例 2：
 *
 * 输入：nums = [2,2,2] [931755]
 * 输出：1
 * 解释：反转每个数字后，结果数组是 [2,2,2,2,2,2] 。
 * 数组中不同整数的数目为 1（数字 2）。
 */
public class countDistinctIntegers {
    public static void main(String[] args) {
        Solution solution = new countDistinctIntegers().new Solution();
        int[] nums = {931755};
        System.out.println(solution.countDistinctIntegers(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDistinctIntegers(int[] nums) {
//            if (nums.length ==1) return 1;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int rever = reverse(nums[i]);
                if (!set.contains(nums[i])){
                    set.add(nums[i]);
                }
                if (!set.contains(rever)) set.add(rever);
            }

            return set.size();

        }

        private int reverse(int num){
            StringBuilder s = new StringBuilder(String.valueOf(num));
            String reverse = s.reverse().toString();
            return Integer.parseInt(reverse);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
