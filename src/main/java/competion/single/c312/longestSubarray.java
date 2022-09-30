package competion.single.c312;

/**
 * 给你一个长度为 n 的整数数组 nums 。
 *
 * 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。
 *
 * 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。
 * 返回满足要求的 最长 子数组的长度。
 *
 * 数组的按位与就是对数组中的所有数字进行按位与运算。
 *
 * 子数组 是数组中的一个连续元素序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,3,2,2]
 * 输出：2
 * 解释：
 * 子数组按位与运算的最大值是 3 。
 * 能得到此结果的最长子数组是 [3,3]，所以返回 2 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：1
 * 解释：
 * 子数组按位与运算的最大值是 4 。
 * 能得到此结果的最长子数组是 [4]，所以返回 1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *nums = [1,2,3,3,2,2]
 */
public class longestSubarray {
    public static void main(String[] args) {
        Solution solution = new longestSubarray().new Solution();
        int[] nums = {1,2,3,3,2,2,3};
        System.out.println(solution.longestSubarray(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //脑筋急转弯，
        // 1.按位与有个特点，是a和b按位与的结果小于等于两者的较小者
        // 2.数组中按位与的最大值是最大值（极端情况下一个人）
        // 求得到按位与运算得到最大值子数组的长度，说人话就是求连续最大值的个数

        public int longestSubarray(int[] nums) {
            int max = 1; //最大值
            int result = 0; //返回的结果
            int curr = 0; //标识是否连续

            for (int num : nums) {
                if (num == max) {
                    curr= curr+1;
                    result = Math.max(result, curr);
                } else if (num > max) {
                    max = num;
                    result = curr = 1;
                } else {
                    curr = 0;
                }
            }
            return result;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
