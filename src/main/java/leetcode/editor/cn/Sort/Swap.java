package leetcode.editor.cn.Sort;

import java.util.Arrays;

/**
 * 交换两个数
 */
public class Swap {
    public static void main(String[] args) {
        Solution solution = new Swap().new Solution();
        int[] arr = {2,3};
        solution.swap2(arr,0,1);
//        solution.swap(arr,0);
        System.out.println(Arrays.toString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 交换arr数组中i位置和j位置，引入了第三个变量
         * @param nums
         * @param i
         * @param j
         */
        public  void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        /**
         * 交换arr中j和j+1的位置，不引入第三个变量，但可能会导致数组越界，要特别注意
         * @param nums
         * @param j
         */
        public  void swap(int[] nums, int j){
            nums[j + 1] = nums[j + 1] + nums[j];  //j+1位置= sum（j,j+1）
            nums[j] = nums[j + 1] - nums[j];    //j位置= sum - nums[j]，实现了交换，为j+1原来的值
            nums[j + 1] = nums[j + 1] - nums[j]; //j+1位置 = sum -新值

        }
        //参照上述写出的两个位置
        public  void swap1(int[] nums, int i, int j){
            nums[j] = nums[i]+nums[j];
            nums[i] = nums[j] -nums[i];
            nums[j] = nums[j]-nums[i];
        }


        /**
         * 通过位运算完成数字交换
         * @param nums
         * @param i
         * @param j
         */
        public  void swap2(int[] nums, int i, int j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[j] ^ nums[i];
            nums[i] = nums[i] ^ nums[j];
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
