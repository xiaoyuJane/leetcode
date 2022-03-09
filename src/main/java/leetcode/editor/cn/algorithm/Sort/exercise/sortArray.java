package leetcode.editor.cn.algorithm.Sort.exercise;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 * 相关标签
 * 数组
 * 分治
 * 桶排序
 * 计数排序
 * 基数排序
 * 排序
 * 堆（优先队列）
 * 归并排序

 */
public class sortArray {
    public static void main(String[] args) {
        Solution solution = new sortArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用快速排序完成
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            quicksort(nums,0,n-1);
            return nums;
        }


        /**
         * 对[left,right]区间做快速排序
         * 取第一个数为基数来对数组做分区，并获得中间值对应的下标
         * @param nums
         * @param left
         * @param right
         */
        private void quicksort(int[] nums, int left, int right) {
            if (left>=right) return;

            int mid = partion(nums,left,right);
            quicksort(nums,left,mid-1);
            quicksort(nums,mid+1,right);
        }

        /**
         * 找到基数正确的下标位置的过程
         * @param nums
         * @param left
         * @param right
         * @return mid
         */
        private int partion(int[] nums, int left, int right) {
            int pivot = nums[left];
            int i = left+1;
            int j = right;

            //i和j相遇之前，每找到一个比基数大的值，都交换到j位置，并且j前移
            //i和j相遇，代表已经找到了所有比基数大的值了
            while (i<j){
                //1.找到比基数大的位置
                while (i<j && nums[i] <= pivot) i++;
                //2.将大的位置与j对应的尾部交换，j代表以及确定的大的数的位置，所以j前移自减
                if (i!=j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    j--;
                }
            }
            //单独比较i和j相等这一位置的值，如果大于基数，那么存放基数位置的j应该前移
            if (i == j && nums[j]>pivot) j--;

            //如果存放基数位置的j不是原始位置，那么交换基数到j位置，返回j为基数的下标
            if (j!= left) {
                int tmp = nums[j];
                nums[j] = nums[left];
                nums[left] = tmp;

            }
            return j;



        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
