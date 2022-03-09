package leetcode.editor.cn.DS.List;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        请必须使用时间复杂度为 O(log n) 的算法。
//
//         
//
//        示例 1:
//
//        输入: nums = [1,3,5,6], target = 5
//        输出: 2
//        示例 2:
//
//        输入: nums = [1,3,5,6], target = 2
//        输出: 1
//        示例 3:
//
//        输入: nums = [1,3,5,6], target = 7
//        输出: 4
//        示例 4:
//
//        输入: nums = [1,3,5,6], target = 0
//        输出: 0
//        示例 5:
//
//        输入: nums = [1], target = 0
//        输出: 0
//         
//
//        提示:
//
//        1 <= nums.length <= 104
//        -104 <= nums[i] <= 104
//        nums 为无重复元素的升序排列数组
//        -104 <= target <= 104
//        相关标签
//        数组
//        二分查找

public class searchInsert {
    public static void main(String[] args) {
        Solution solution = new searchInsert().new Solution();
        int[] nums = new int[]{1};
        System.out.println(solution.searchInsert(nums,0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 经典的二分法思路：设置左右指针，比较mid，对半折
         *  public int searchInsert(int[] nums, int target) {
         *         int left = 0, right = nums.length - 1;            // 注意
         *         while(left <= right) { // 注意
         *             int mid = (left + right) / 2;                // 注意
         *             if(nums[mid] == target) {                   // 注意
         *                 // 相关逻辑
         *             } else if(nums[mid] < target) {
         *                 left = mid + 1;                         // 注意
         *             } else {
         *                 right = mid - 1;                       // 注意
         *             }
         *         }
         *         // 相关返回值
         *         return 0;
         *     }
         *
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
           int left=0;
           int right = nums.length-1;

           while (left<=right){
               int mid = (left+right)/2;
               if (nums[mid] == target) return mid;
               else if (nums[mid] < target) left = mid +1;
               else right = mid-1;
           }
           return left;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
