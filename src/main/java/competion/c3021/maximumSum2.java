package competion.c3021;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 6164. 数位和相等数对的最大和
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），
 * 且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 *
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 *
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
public class maximumSum2 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 算法2：通过排序，巧妙解决最大值问题
         * 这里使用map，key为数位和，value为存入的最大num
         * 因为排序后，更新数位和时，可以直接放入当前的nums[i],即可确保放入的和得到的都是当前最大的
         * @param nums
         * @return
         */
        public int maximumSum(int[] nums) {
            Arrays.sort(nums);
            int max = -1;

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int sum = getBitSum(nums[i]);
                if (map.containsKey(sum))  max = Math.max(map.get(sum)+nums[i],max);
                map.put(sum,nums[i]);
            }
            return max;


        }

        public int getBitSum(int num){
            int sum = 0;
            while (num!=0){
                sum += num%10;
                num /=10;
            }
            return sum;
        }

        }

    //leetcode submit region begin(Prohibit modification and deletion)
}
