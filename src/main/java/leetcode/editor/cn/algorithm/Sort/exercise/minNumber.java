package leetcode.editor.cn.algorithm.Sort.exercise;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 相关标签
 * 贪心
 * 字符串
 * 排序
 */

public class minNumber {
    public static void main(String[] args) {
        Solution solution = new minNumber().new Solution();
        int[] nums = {0,9,8,7,6,5,4,3,2,1};
        System.out.println(solution.minNumber1(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 基于冒泡排序的思想，从小到大，找到最应该排在第一位的（最小），最应该排在最后一位的（最大）
         * @param nums
         * @return
         */
        public String minNumber(int[] nums) {

            bubblesort(nums);
            return Arrays.toString(nums).replaceAll("\\[|]|,|\\s","");
        }

        private void bubblesort(int[] nums) {
            boolean swapped = true;
            int j = nums.length-1;
            int index = -1; //发生交换的位置
            while (swapped){
                swapped = false;
                for (int i = 0; i < j; i++) {
                    String ab = String.valueOf(nums[i]) + String.valueOf(nums[i+1]);
                    String ba = String.valueOf(nums[i+1]) + String.valueOf(nums[i]);
                    if (ab.compareTo(ba)>0){
                            swap(nums,i,i+1);
                            swapped = true;
                            index = i;
                    }
                }

                j=index;
            }
        }

        private void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums [j];
            nums[j] = temp;
        }


        /**
         自定义排序
         * @param nums
         * @return
         */
        public String minNumber1(int[] nums) {
            String[] res = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(res,(x,y)->(x+y).compareTo(y+x));
            StringBuilder ans = new StringBuilder();
            for (String s:res
                 ) {ans.append(s);
            }

            return ans.toString();
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
