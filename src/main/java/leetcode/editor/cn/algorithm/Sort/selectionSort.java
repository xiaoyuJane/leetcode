package leetcode.editor.cn.algorithm.Sort;

/**
 * 选择排序
 * 两层循环，时间复杂度为 O(n^2)
 * 空间复杂度 O(1)
 * 选择最小值交换过程中，i和min位置交换，存在i位置跑到了相等值的j位置之后的情况，所以它是不稳定的
 */
public class selectionSort {
    public static void main(String[] args) {
        Solution solution = new selectionSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 通用选择排序，每一轮遍历记录最小位置的下标，与首位交换，
         * 第一轮遍历为0到len-2
         * 第二轮遍历为i+1到len-1
         * @param arr
         */
        public  void selectionSort(int[] arr) {
            int min;
            for (int i = 0; i < arr.length - 1; i++) {
                min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[min] > arr[j]) {
                        min = j; // 记录最小值的下标
                    }
                }
                // 将最小元素交换至首位（从i开始，所以i为首位）
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        /**
         * 二元选择排序
         * 既然每轮遍历时找出了最小值，何不把最大值也顺便找出来，这样第一轮遍历的次数会减半，第二轮遍历比较次数增加
         *
         * @param arr
         */
        public  void selectionSort2(int[] arr) {

            int n = arr.length;
            // i 只需要遍历一半
            for(int i = 0; i< n/2; i++){
                int min = i;
                int max = i;
                //1.第二层遍历，找出最大值最下值下标，进行交换
                for(int j = i+1;j<n-i;j++){ //内层是真正做选择的圈次
                    if(arr[j]<arr[min]) min=j;
                    if(arr[j]>arr[max]) max=j;
                }

                // 2.退出条件，当最大值和最小值都相等说明走到了尽头
                if(min == max) break;
                swap(arr,i,min);
                // 注意点：如果最大值的下标刚好是 i，由于 arr[i] 和 arr[minIndex] 已经交换了，所以这里要更新 maxIndex 的值。
                if(max == i) max=min;
                swap(arr,n-i-1,max);
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
