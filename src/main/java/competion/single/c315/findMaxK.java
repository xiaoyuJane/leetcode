package competion.single.c315;

import java.util.Arrays;

/**
 *
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * 示例 2：
 *
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * 示例 3：
 *
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 */
public class findMaxK {
    public static void main(String[] args) {
        Solution solution = new findMaxK().new Solution();
        int[] nums = {-1,2,-3,3};
        System.out.println(solution.findMaxK(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxK(int[] nums) {
            int res =-1;
            int n = nums.length;
            if (n==1) return res;

            Arrays.sort(nums);
            for (int i = 0,j=n-1; i < j ;) {
                if (nums[i]+nums[j]>0) {
                    j--;
                }else if (nums[i]+nums[j]==0) return nums[j];
                else i++;
            }
            return res;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
