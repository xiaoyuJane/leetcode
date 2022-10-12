package DayExe.DS2.D5;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 */
public class subarraySum {
    public static void main(String[] args) {
        Solution solution = new subarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 连续子数组的限定
        //对每个 i，我们需要枚举所有的 j 来判断是否符合条件
        public int subarraySum(int[] nums, int k) {
            int count = 0;

            for (int start = 0; start < nums.length; ++start) {
                int sum = 0;
                //从后往前找（这是一个很重要的概念），找用到一个，count自增
                for (int end = start; end >= 0; --end) {
                    sum += nums[end];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;

        }


        //前缀和方法,建立前缀和数组，连续子数组和为k，即sum[i]-sum[j-1]=k
        public int subarraySum1(int[] nums, int k){
            int count =0;
            int pre =0; //当前元素对应的sum
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre-k)) count+=map.get(pre-k);
                map.put(pre,map.getOrDefault(pre,0)+1);
            }
            return count;


        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
