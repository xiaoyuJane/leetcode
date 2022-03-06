package leetcode.editor.cn.Sort.exercise;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * 给定长度为 2n 的整数数组 nums ，
 * 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 *
 * 示例 1：
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * 示例 2：
 *
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -10^4 <= nums[i] <= 10^4
 * 相关标签
 * 贪心
 * 数组
 * 计数排序
 * 排序

 */
public class arrayPairSum {
    public static void main(String[] args) {
        Solution solution = new arrayPairSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //先排序，再取奇数相加
        public int arrayPairSum(int[] nums) {
            radixSort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i += 2) {
                result+=nums[i];
            }
            return result;

         
        }

        private void radixSort(int[] arr) {
            int max = 0;
            for (int value : arr) {
                if (Math.abs(value) > max) {
                    max = Math.abs(value);
                }
            }

            int n = 0;
            while (max != 0) {
                n++;
                max /= 10;
            }

            int[] counting = new int[19];
            int[] result = new int[arr.length];
            int dev = 1;

            for (int i = 0; i < n; i++) {
                for (int value : arr) {
                    // 下标调整
                    int radix = value / dev % 10 + 9;
                    counting[radix]++;
                }
                for (int j = 1; j < counting.length; j++) {
                    counting[j] += counting[j - 1];
                }
                // 使用倒序遍历的方式完成计数排序
                for (int j = arr.length - 1; j >= 0; j--) {
                    // 下标调整
                    int radix = arr[j] / dev % 10 + 9;
                    result[--counting[radix]] = arr[j];
                }
                // 计数排序完成后，将结果拷贝回 arr 数组
                System.arraycopy(result, 0, arr, 0, arr.length);
                // 将计数数组重置为 0
                Arrays.fill(counting, 0);
                dev *= 10;

            }


        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
