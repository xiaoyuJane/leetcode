package leetcode.editor.cn.greed;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

 */
public class majorityElement {
    public static void main(String[] args) {
        Solution solution = new majorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //众数一定是存在一大半的数，遍历数组，如果count值为0，对应的item赋值给candiate，
        // 此后遍历，值相等，count加1，值不相等，count减1，因为对于candiate来讲，其最后的值一定是大于n/2的，
        // 即累加下来,count值一定是大于0
        public int majorityElement(int[] nums){
            int count = 0;
            int candiate = nums[0];

            for (int num : nums) {
                if (count == 0) candiate = num;
                count += (num == candiate)?1:-1;
            }
            return candiate;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
