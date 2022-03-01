package leetcode.editor.cn.Sort.exercise;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 相关标签
 * 数组
 * 分治
 * 快速选择
 * 排序
 * 堆（优先队列）

 */
public class getLeastNumbers {
    public static void main(String[] args) {
        Solution solution = new getLeastNumbers().new Solution();
        int[] arr = {0,0,0,1,2,2,3,7,6,1};
        System.out.println(arr.length);
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr,3)).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int res[] = new int[k];
            buildMinHeap(arr);
            for (int i= 0;i<k;i++){
                res[i] = arr[0];
                arr[0] = arr[arr.length-1-i];
                arr[arr.length-1-i] = res[i];

                minHeapify(arr,0,arr.length-1-i);
            }
            return res;
        }

        private void buildMinHeap(int[] arr){
            for (int i = arr.length/2 -1;i>=0;i--){
                minHeapify(arr,i,arr.length);
            }
        }

        private void minHeapify(int[] arr, int i, int heapSize){
            int left = i*2+1;
            int right = left+1;
            int min = i;

            if (left < heapSize && arr[left] < arr[min]) min=left;
            if (right < heapSize && arr[right] < arr[min]) min=right;

            if (min != i){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
                minHeapify(arr,min,heapSize);
            }
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
