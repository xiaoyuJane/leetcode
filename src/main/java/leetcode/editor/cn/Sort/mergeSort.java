package leetcode.editor.cn.Sort;

/**
 * 归并排序，使用了二分的思想（使用递归实现）
 * 归并排序分成两步，一是拆分数组，二是合并数组，它是分治思想的典型应用。分治的意思是“分而治之”，分的时候体现了二分的思想
 * 拆分数组的过程中，会将数组拆分 logn 次，每层执行的比较次数都约等于 n 次，所以时间复杂度是 O(nlogn)。
 * 空间复杂度是 O(n)，主要占用空间的就是我们在排序前创建的长度为 n 的 result 数组。
 * 归并排序是一种稳定的排序算法
 */
public class mergeSort {
    public static void main(String[] args) {
        Solution solution = new mergeSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public  void mergeSort(int[] arr) {
            if (arr.length == 0) return;
            int[] result = new int[arr.length];
            mergeSort(arr, 0, arr.length - 1, result);
        }

        private void mergeSort(int[] arr, int start, int end, int[] result){
            //终止条件
            if (start == end) return;

            //取中点拆分，拆分的终止条件是只剩一个数
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle, result);
            mergeSort(arr, middle + 1, end, result);

            //到只剩一个数后，向上合并成有序的数组
            merge(arr, start, end, result);
        }

        private void merge(int[] arr,int start,int end,int[] result){
            int middle = (start + end) / 2;
            int start2 = middle + 1;

            int i1 = start;
            int i2 = middle+1;
            //核心算法在这里，做交换*****
            while (i1 <= middle && i2 <=end){
                if (arr[i1] <= arr[i2]) result[i1+i2-start2] = arr[i1++]; //小的值放在前面的位置上
                else result[i1+i2-start2] = arr[i2++];
            }

            // 将剩余数字补到结果数组之后
            while (i1<=middle) result[i1+i2-start2] = arr[i1++];
            while (i2<=end) result[i1+i2-start2] = arr[i2++];

            // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
            while (start<=end) arr[start]=result[start++];

        }


        //原地归并排序，不开辟额外空间，即不使用额外的result数组，但是实际上是插入排序，时间复杂度达到了O(N^2)
        //合并 arr 的 [start, middle] 区间和 [middle + 1, end] 区间时，将两个区间较小的数字移动到 i1 的位置，
        // 并且将左边区域不断后移，目的是给新插入的数字腾出位置。最后更新两个区间的下标，继续合并更新后的区间。
        private void merge(int[] arr,int start,int end){
            int mid = (start + end)/2;
            int start2 = mid+1;
            int i1=start, i2=start2;
            while (i1<=mid && i2 <=end){
                if (arr[i1] <= arr[i2]) i1++;
                else {
                    int tmp = arr[i2];
                    int i = i2;
                    while (i>i1){
                        arr[i] = arr[i-1];
                        i--;
                    }
                    arr[i] = tmp;

                    i1++;
                    i2++;
                    mid++;
                }
            }

        }

        private void merge2(int[] arr,int start,int end){
            int mid = (start + end) / 2;
            int start2 = mid + 1;
            // 用来遍历数组的指针
            int i1 = start;
            while (i1 <= mid && start2 <= end) {
                if (arr[i1] > arr[start2]) {
                    // 将 index1 和 start2 下标的数字交换
                    swap(arr, i1, start2);
                    if (start2 != end) {
                        // 调整交换到 start2 上的这个数字的位置，使右边区域继续保持有序
                        int value = arr[start2];
                        int index = start2;
                        // 右边区域比 arr[start2] 小的数字不断前移
                        while (index < end && arr[index + 1] < value) {
                            arr[index] = arr[index + 1];
                            index++;
                        }
                        // 交换到右边区域的这个数字找到了自己合适的位置，坐下
                        arr[index] = value;
                    }
                }
                i1++;
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
