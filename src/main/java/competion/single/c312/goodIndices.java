package competion.single.c312;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
 *
 * 对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
 *
 * 下标 i 之前 的 k 个元素是 非递增的 。
 * 下标 i 之后 的 k 个元素是 非递减的 。
 * 按 升序 返回所有好下标。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,1,1,1,3,4,1], k = 2
 * 输出：[2,3]
 * 解释：数组中有两个好下标：
 * - 下标 2 。子数组 [2,1] 是非递增的，子数组 [1,3] 是非递减的。
 * - 下标 3 。子数组 [1,1] 是非递增的，子数组 [3,4] 是非递减的。
 * 注意，下标 4 不是好下标，因为 [4,1] 不是非递减的。
 * 示例 2：
 *
 * 输入：nums = [2,1,1,2], k = 2
 * 输出：[]
 * 解释：数组中没有好下标。
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 3 <= n <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= k <= n / 2
 *

 */
public class goodIndices {
    public static void main(String[] args) {
        Solution solution = new goodIndices().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 数学公式法
     */
    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int[] left = new int[nums.length], right = new int[nums.length];

            //下标i之前的k个元素是非递增的线段数 。
            for (int i = 2; i < nums.length; i++) {
                //如果后面元素比前一个元素大，即为递增的，不满足非递增，left[i]=0;
                if (nums[i - 1] > nums[i - 2]) {
                    left[i]=0;
                }
                //否则是递增的，在前一个结果上+1
                else left[i]= left[i - 1] + 1;
            }

            //下标i之后的k个元素是非递减的线数
            for (int i = nums.length - 3; i >= 0; i--) {
                //如果后前面元素比后一个元素大，即为递减的，不满足非递减，right[i]=0;
                if(nums[i + 1] > nums[i + 2]){
                    right[i] =  0;
                }else{
                    //否则是递减的，在前一个结果上+1
                    right[i] =  right[i + 1] + 1;
                }
            }

            //定义结果集，分别满足两个条件：
            // i之前，k个元素非递增，等价于k-1段非递增的线；
            // i之后，k个元素非递减，等价于k-1段非递减的线
            List<Integer> list = new ArrayList<>();
            for (int i = k; i < nums.length - k; ++i) {
                if (left[i] >= k - 1 && right[i] >= k - 1) {
                    list.add(i);
                }
            }
            return list;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
