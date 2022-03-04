package leetcode.editor.cn.Sort.exercise;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * 相关标签
 * 数组
 * 双指针
 */
public class moveZeroes {
    public static void main(String[] args) {
        Solution solution = new moveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考冒泡，将0冒泡到最后，使用标记位做剪枝操作
        public void moveZeroes(int[] nums) {
            boolean swapped = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (!swapped) break;

                swapped = false;
                for (int j = 0; j < nums.length-i-1; j++) {
                    if (nums[j] == 0) {
                        swap(nums,j,j+1);
                        swapped = true;
                    }
                }
            }

        }

        private void swap(int[] nums, int i, int i1) {
            int tmp = nums[i];
            nums[i] = nums[i1];
            nums[i1] = tmp;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
