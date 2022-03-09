package leetcode.editor.cn.algorithm.Sort.exercise;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *  
 *
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
 */

//这种只需要部分排序的场景，非常适合用选择排序或堆排序来完成。
// 因为他们的排序过程都是每次找出数组中的最大值（或最小值），依次将每个数字排好序。
// 这两者之间，堆排序在性能上又比选择排序更好。

public class findKthLargest {
    public static void main(String[] args) {
        Solution solution = new findKthLargest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            buildMaxHeap(nums);
            for (int i=0;i<k-1;i++){
                swap(nums,0,nums.length-1-i);
                maxHeapify(nums,0,nums.length-1-i);
            }
            return nums[0];
        }
        // 构建初始大顶堆
        private  void buildMaxHeap(int[] arr) {
            // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                maxHeapify(arr, i, arr.length);
            }
        }

        // 调整大顶堆，第三个参数表示剩余未排序的数字的数量，也就是剩余堆的大小
        // 递归调用
        private  void maxHeapify(int[] arr, int i, int heapSize) {
            int largest = i;// 记录根结点、左子树结点、右子树结点三者中的最大值下标
            int l = 2 * i + 1;// 左子结点下标
            int r = l + 1;// 右子结点下标

            // 与左子树结点比较
            if (l < heapSize && arr[l] > arr[largest]) {
                largest = l;
            }
            // 与右子树结点比较
            if (r < heapSize && arr[r] > arr[largest]) {
                largest = r;
            }

            if (largest != i) {
                // 将最大值交换为根结点
                swap(arr, i, largest);
                // 再次调整交换数字后的大顶堆
                maxHeapify(arr, largest, heapSize);
            }
        }
        public  void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
