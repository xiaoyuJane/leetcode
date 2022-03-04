package leetcode.editor.cn.Sort.exercise;

/**
 * 数组中的第 K 个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * 相关标签
 * 数组
 * 分治
 * 快速选择
 * 排序
 * 堆（优先队列）

 */
public class findKthLargestSelect {
    public static void main(String[] args) {
        Solution solution = new findKthLargestSelect().new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution.findKthLargest2(nums,2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            ssort(nums);
            return nums[nums.length-k];
        }

        //从大往下排序，排序到第k次退出
        public int findKthLargest2(int[] nums, int k) {
            int n = nums.length;
            for (int i = 0; i < nums.length-1 ; i++){
                if (i == k) break;
                int max = i;
                for (int j = i+1; j <nums.length ; j++) {
                    if (nums[j] > nums[max]) max=j;
                }
                swap(nums,i,max);
            }
            return nums[k-1];
        }

        private void ssort(int[] nums){
            int n = nums.length;
            for (int i = 0; i < n-1 ; i++) {
                int min =i;
                for (int j = i+1; j < n; j++) {
                    if (nums[j]<nums[min]) {
                        min = j;
                    }
                }
                swap(nums,i,min);
            }
        }

        private void swap(int[] nums,int i,int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
