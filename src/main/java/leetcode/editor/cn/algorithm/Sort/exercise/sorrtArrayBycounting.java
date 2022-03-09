package leetcode.editor.cn.algorithm.Sort.exercise;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 * 相关标签
 * 数组
 * 分治
 * 桶排序
 * 计数排序
 * 基数排序
 * 排序
 * 堆（优先队列）
 * 归并排序

 */
public class sorrtArrayBycounting {
    public static void main(String[] args) {
        Solution solution = new sorrtArrayBycounting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            int min = nums[0];
            int max = nums[0];

            //找到最大值和最小值
            for(int i=0;i<n;i++){
                if(nums[i]<min) min = nums[i];
                if(nums[i]>max) max = nums[i];
            }

            int [] counting = new int[max-min+1];

            for(int num :nums){
                counting[num-min]++;
            }

            int index =0;
            for(int i=0;i<max-min+1;i++){
                while(counting[i]!=0){
                    nums[index++] = i+min;
                    counting[i]--;
                }
            }
            return nums;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
