package leetcode.editor.cn.algorithm.Sort.exercise;

import java.util.Arrays;

/**
 * 164. 最大间距
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *  
 * 提示:
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 相关标签
 * 数组
 * 桶排序
 * 基数排序
 * 排序

 */
public class maximumGap {
    public static void main(String[] args) {
        Solution solution = new maximumGap().new Solution();
        int[] arr ={8,7,1,2,8,6,2};
        int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,
                15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,
                22101,32406,21540,31799,3768,26679,21799,23740};
        solution.radixsort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //明确线性时间和线性空间，所以先比较再计算最大差值
        //另外数组的值覆盖范围较广，不适合使用计数排序，都为正数，只能使用基数排序
        public int maximumGap(int[] nums) {
            int n = nums.length;

            if(n <2) return 0;

            radixsort(nums);
            int max=0;
            for (int i = 0; i < n-1; i++) {
                max = Math.max(nums[i + 1] - nums[i], max);
            }
            return max;

        }

        private void radixsort(int[] nums) {
            //求最大值
            int max = nums[0];
            for (int num : nums) max = Math.max(num,max);

            //求位数
            int n = 0;
            while (max!=0){
                n++;
                max = max/10;
            }
            //对n遍历，从低位先遍历起，所以是tmp=1；
            int tmp =1;
            int[] couting = new int[10];
            int[] res = new int[nums.length];
            for (int i = 0; i <n ; i++) {
                for (int num :nums) {
                    int radix = num/tmp %10;
                    couting[radix]++;
                }
                //计算j位置占数组的实际位置
                for (int j = 1; j < couting.length; j++) {
                    couting[j] = couting[j-1]+couting[j];
                }

                for (int j = nums.length - 1; j >= 0; j--) {
                    int radix = nums[j] / tmp % 10;
                    res[--couting[radix]] = nums[j];
                }

                //参数分别为源数组，源数组起始位置，目标数组，目标数组起始位置，拷贝长度
                System.arraycopy(res,0,nums,0,res.length);
                Arrays.fill(couting,0);
                tmp = tmp *10;

            }



        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
