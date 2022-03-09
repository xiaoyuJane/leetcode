package leetcode.editor.cn.DS.List.array;

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -104 <= target <= 104 
// 
// Related Topics 数组 双指针 排序 
// 👍 1014 👎 0

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length -1;

            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                if (diff == 0) return sum;

                //迭代取最小的值，并获取result
                if (diff < min){
                    min = diff;
                    result = sum;
                }
                //有序，左右逼近
                if (sum < target) start++;
                else end--;
            }
        }


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}