package leetcode.editor.cn.DS.List.array.exercise;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4215 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<List<Integer>>();

        if (nums.length<3) return result;

        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){

            //去重手段1，如果存在nums[i]相等的情况，后来的情况与之前的情况相同，只计算一次，直接i++
            if(i==0||nums[i]>nums[i-1]){
                int temp = -nums[i];
                int start = i+1;
                int end = nums.length-1;

                while (start<end){
                    if (nums[start]+nums[end]==temp){
                        List<Integer> res = new ArrayList<Integer>();
                        res.add(nums[i]);
                        res.add(nums[start]);
                        res.add(nums[end]);
                        result.add(res);
                        start++;
                        end--;

                        //去重手段2，针对start和end的只计算一次
                        while(start<end && nums[end]==nums[end+1]) end--;
                        while (start<end && nums[start]==nums[start-1]) start++;

                    }
                    else if (nums[start]+nums[end]<temp){
                        start++;
                    }
                    else {
                        end--;
                    }
                }
            }

        }

        return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}