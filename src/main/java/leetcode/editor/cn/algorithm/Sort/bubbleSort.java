package leetcode.editor.cn.algorithm.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 两层循环，时间复杂度为 O(n^2)
 *  * 空间复杂度 O(1)
 *  冒泡排序中，只有左边的数字大于右边的数字时才会发生交换，相等的数字之间不会发生交换，所以它是稳定的
 */
public class bubbleSort {
    public static void main(String[] args) {
        Solution solution = new bubbleSort().new Solution();
        int[] arr = new int[]{6, 2, 1, 3, 5, 4};
        solution.bubbleSort(arr);
        // 输出: [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(arr));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //冒泡排序-原始代码

        /**
         * 主要是两两比较，2个相邻元素局部有序
         * 外层循环次数为n-1，内层循环区间为0~ n-i-1
         * @param arr
         */
        public  void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) { //i 控制的是第二层循环的终止条件：j < arr.length - 1 - i，不代表下标情况
                //经过第一轮i，右边有序1个数，j的有效空间为0到n-i-1
                for (int j = 0; j < n - 1 - i; j++) { //j 运行的有效区间为0到arr.length - 1 - i。最右边存放的是有序的部分

                    if (arr[j] > arr[j + 1]) {// 如果左边的数大于右边的数，则交换，保证右边的数字最大
                        swap(arr, j, j + 1);
                    }
                }
            }
        }

        /**
         * 冒泡优化：增加swapped标志位，表示在外层遍历的过程中，是否发生了交换（只要有一次发生交换就算发生了交换），
         * 如果没有发生交换，表示两两全都有序，即为整体有序
         * @param arr
         */
        public  void bubbleSort2(int[] arr) {
            // 初始时 swapped 为 true，否则排序过程无法启动
            boolean swapped = true;
            for (int i = 0; i < arr.length - 1; i++) {
                // ****增加类似于剪枝的操作：如果一轮比较中没有发生过交换，则立即停止排序，因为此时剩余数字一定已经有序了
                if (!swapped) break;

                // 初始设置 swapped 为 false，如果发生交换，则将其置为 true
                swapped = false;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) { // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                        swap(arr, j, j + 1);
                        swapped = true; // 表示发生了交换
                    }
                }
            }
        }

        /**
         *优化点：外层循环的终止条件仍然是有没有交换产生，没有的话表明整体有序
         * 如果有交换产生，比较0到最后一次发生交换的位置indexOfLastUnsortedElement（该位置之后未发生交换说明以及是有序）
         * @param arr
         */
        public  void bubbleSort3(int[] arr) {

            boolean swapped = true;
            int indexOfLastUnsortedElement = arr.length - 1; // 最后一个没有经过排序的元素的下标
            int swappedIndex = -1; // 上次发生交换的位置

            while (swapped) {
                swapped = false;
                for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                    //在下一轮比较时，只需比较到上一轮比较中，最后一次发生交换的位置即可。因为后面的所有元素都没有发生过交换，必然已经有序了。
                    if (arr[i] > arr[i + 1]) {// 如果左边的数大于右边的数，则交换，保证右边的数字最大
                        swap(arr, i, i + 1);
                        swapped = true; // 表示发生了交换
                        swappedIndex = i; // 更新交换的位置
                    }
                }
                indexOfLastUnsortedElement = swappedIndex; // 最后一个没有经过排序的元素的下标就是最后一次发生交换的位置
            }
        }




        // 交换元素
        private  void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
