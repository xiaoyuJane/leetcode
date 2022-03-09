package leetcode.editor.cn.algorithm.Sort;

/**
 * 插入排序过程需要两层循环，时间复杂度为 O(n^2),只需要常量级的临时变量，空间复杂度为 O(1)
 * 交换法：在新数字插入过程中，不断与前面的数字交换，直到找到自己合适的位置。
 * 移动法：在新数字插入过程中，与前面的数字不断比较，前面的数字不断向后挪出位置，当新数字找到自己的位置后，插入一次即可。
 * 稳定的排序算法
 *
 */
public class insertSort {
    public static void main(String[] args) {
        Solution solution = new insertSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 插入排序，参考抽扑克排序
         * @param arr
         */
        public  void insertSort(int[] arr) {

            for (int i = 1; i < arr.length; i++) {// 从第二个数开始，往前插入数字，遍历n-1次
                int j = i;  // j 从当前位置往前遍历，与前面的比较，小的放前面，这样使得局部有序
                while (j >= 1 && arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);  // 当前数字比前一个数字小，则将当前数字与前一个数字交换
                    j--;  // ，由于是往前遍历，所以更新当前数字下标为减减
                }
            }
        }
        private  void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /**
         * 移动法插入排序
         * @param arr
         */
        public  void insertSort1(int[] arr) {
            // 从第二个数开始，往前插入数字
            for (int i = 1; i < arr.length; i++) {
                int currentNumber = arr[i];
                int j = i - 1;
                // 寻找插入位置的过程中，不断地将比 currentNumber 大的数字向后挪
                while (j >= 0 && currentNumber < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                // 两种情况会跳出循环：1. 遇到一个小于或等于 currentNumber 的数字，跳出循环，currentNumber 就坐到它后面。
                // 2. 已经走到数列头部，仍然没有遇到小于或等于 currentNumber 的数字，也会跳出循环，此时 j 等于 -1，currentNumber 就坐到数列头部。
                arr[j + 1] = currentNumber;
            }
        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
