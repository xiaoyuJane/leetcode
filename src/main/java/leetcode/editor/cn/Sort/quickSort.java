package leetcode.editor.cn.Sort;

/**
 *快速排序，采用了分治的算法
 * 从数组中取出一个数，称之为基数（pivot）
 * 遍历数组，将比基数大的数字放到它的右边，比基数小的数字放到它的左边。遍历完成后，数组被分成了左右两个区域
 * 将左右两个区域视为两个数组，重复前两个步骤，直到排序完成
 *
 *   * 基数的选择有三种方式：
 *          *  选择第一个元素作为基数
 *          *  选择最后一个元素作为基数
 *          *  选择区间内一个随机元素作为基数
 *
 * 快速排序的每一次遍历，都将基数摆到了最终位置上。
 * 第一轮遍历排好 1 个基数，第二轮遍历排好 2 个基数（每个区域一个基数，但如果某个区域为空，则此轮只能排好一个基数），第三轮遍历排好 4 个基数（同理，最差的情况下，只能排好一个基数），以此类推。
 * 总遍历次数为 logn～n 次，
 * 每轮遍历的时间复杂度为 O(n)，
 * 所以很容易分析出快速排序的时间复杂度为 O(nlogn) ～ O(n^2)，平均时间复杂度为 O(nlogn)，时间复杂度是 O(nlogn)
 * 空间复杂度与递归的层数有关，每层递归会生成一些临时变量，所以空间复杂度为 O(logn) ~ O(n)，平均空间复杂度为 O(logn)

 * 快速排序不稳定
 */
public class quickSort {
    public static void main(String[] args) {
        Solution solution = new quickSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public  void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }
        public  void quickSort(int[] arr, int start, int end) {
            //递归终止条件
           if (start >= end) return;

           int middle = partition(arr,start,end);
           quickSort(arr,start,middle-1);
            quickSort(arr,middle+1,end);
        }

        /**
         * 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
         *从 left 开始，遇到比基数大的数，就交换到数组最后，并将 right 减一，
         * 直到 left 和 right 相遇，此时数组就被分成了左右两个区域。再将基数和中间的数交换，返回中间值的下标即可。
         * @param arr
         * @param start
         * @param end
         * @return
         */
        public  int partition(int[] arr, int start, int end) {
            int pivot = arr[start]; //取第一个数为基数
            int left = start+1;
            int right = end;
            while (left<right){ //left 和right相遇时退出循环

                // 找遇到比基数大的数，就交换到数组最后
                while (left<right && arr[left] <= pivot) left++;
                if (left!=right) {
                    swap(arr,left,right);
                    right--;
                }
            }
            //因为我们选择了数组的第一个元素作为基数，并且分完区后，会执行将基数和中间值交换的操作，
            // 这就意味着交换后的中间值会被分到左边区域。所以我们需要保证中间值的下标是分区完成后，最后一个比基数小的值，所以right--
            if (left == right && arr[right] > pivot) right--;


            //交换基数到right位置（因为right指的是值大的）
            if (right!=start) swap(arr,start,right);
            return right;
        }


        //双指针分区算法
        //从 left 开始，遇到比基数大的数，记录其下标；
        // 再从 right 往前遍历，找到第一个比基数小的数，记录其下标；
        // 然后交换这两个数。继续遍历，直到 left 和 right 相遇。
        // 然后就和刚才的算法一样了，交换基数和中间值，并返回中间值的下标。

        public  int partition2(int[] arr, int start, int end){
            int pivot = arr[start];// 取第一个数为基数
            int left = start + 1,right = end;// 从第二个数开始分区
            while (left<right){
                // 找到第一个大于基数的位置
                while (left < right && arr[left] <= pivot) left++;
                // 找到第一个小于基数的位置
                while (left < right && arr[right] >= pivot) right--;
                // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
                if (left < right) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }
            }
            // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
            if (left == right && arr[right] > pivot) right--;

            swap(arr,start,right);
            return right;

        }


        public  void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
